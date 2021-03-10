package services;

import DTOs.ItemInBasketDTO;
import DTOs.UserBasketDTO;
import javaBean.User;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Stateful
public class UserService {
    private final PasswordHasher passwordHasher = new PasswordHasher();
    private final DBManager dbManager = new DBManager();

    public Optional<User> fetchUser(String email, String password) {
        try {
            String passwordHashed = this.passwordHasher.hash(password);
            EntityManagerFactory emFactoryObj;
            String PERSISTENCE_UNIT_NAME = "DefaultManager";

            emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

            EntityManager em = emFactoryObj.createEntityManager();
            if (em == null) throw new NullPointerException("myBarEntityManager not injected");

            Query query = em.createQuery("SELECT u FROM User u WHERE u.email=:email and u.passwordHash=:password_hash");
            query.setParameter("email", email);
            query.setParameter("password_hash", passwordHashed);
            User user = (User) query.getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public int registerNewUser(String firstname, String lastname, String email, String password) {
        try {
            String passwordHashed = this.passwordHasher.hash(password);
            String query = String.format("insert into customer(firstname, lastname, password_hash, email) values ('%s', '%s', '%s', '%s')", firstname, lastname, passwordHashed, email);

            return this.dbManager.update(query);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
            return 0;
        }
    }

    public UserBasketDTO getUserBasketInfo(int userId)  {

        try {
            int basketId = getBasketId(userId);

            UserBasketDTO result = new UserBasketDTO(basketId);

            ResultSet itemsInBasket = this.dbManager.select("select i.id, i.name, i.price, sbi.count from shopping_basket_item as sbi " +
                    "join item i on sbi.item_id = i.id " +
                    String.format("where sbi.basket_id = %d", basketId));
            while (itemsInBasket.next()) {
                int itemId = itemsInBasket.getInt(1);
                String itemName = itemsInBasket.getString(2);
                double itemPrice = itemsInBasket.getDouble(3);
                int itemsCount = itemsInBasket.getInt(4);

                result.addItem(new ItemInBasketDTO(itemId, itemName, itemPrice, itemsCount));
            }

            return result;
        } catch (Exception e) {

        }

        return new UserBasketDTO(0);
    }

    public void putDataToBasket(int userId, int itemId, boolean isAdd) {
        int basketId = getBasketId(userId);
        try{
            int currentItemsCount = 0;
            ResultSet currentItemsCountSelect = this.dbManager.select("SELECT count FROM shopping_basket_item " +
                String.format("where basket_id=%d and item_id=%d ", basketId, itemId));
            while (currentItemsCountSelect.next()) {
                currentItemsCount = currentItemsCountSelect.getInt(1);
            }
            if(currentItemsCount == 0){
                if(isAdd){
                    this.dbManager.update("INSERT INTO shopping_basket_item (basket_id, item_id, count) " +
                        String.format("values(%d, %d, 1)", basketId, itemId, currentItemsCount + 1));
                }
            }
            else{
                if(isAdd || (!isAdd && currentItemsCount > 1))
                    this.dbManager.update("UPDATE shopping_basket_item " +
                        String.format("set count=%d ", isAdd ? currentItemsCount + 1 : currentItemsCount - 1) +
                        String.format("where basket_id=%d and item_id=%d", basketId, itemId));
                if(!isAdd && currentItemsCount == 1)
                    this.dbManager.update("DELETE FROM shopping_basket_item " +
                        String.format("where basket_id=%d and item_id=%d", basketId, itemId));
            }
        }
        catch(Exception e) {
            System.out.println("putDataToBasket Exception: " + e.getMessage() );
        }
    }

    public void confirmOrder(int userId) {
        int basketId = getBasketId(userId);
        try{
            this.dbManager.update("UPDATE shopping_basket SET date = current_timestamp " +
                    String.format("where id=%d", basketId));
            this.dbManager.update("INSERT INTO shopping_basket (customer_id) " +
                    String.format("values(%d)", userId));
        }
        catch(Exception e){
            System.out.println("confirmOrder Exception: " + e.getMessage() );
        }
    }

    private int getBasketId(int userId) {
        int basketId = -1;
        try{
            ResultSet basket = this.dbManager.select("SELECT id FROM shopping_basket " +
                    String.format("where customer_id=%d and date is null", userId));
            while (basket.next()) {
                basketId = basket.getInt(1);
            }
        }
        catch (Exception e){}
        return basketId;
    }
}
