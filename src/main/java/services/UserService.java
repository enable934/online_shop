package services;

import DTOs.ItemInBasketDTO;
import DTOs.UserBasketDTO;
import javaBean.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserService {
    private final PasswordHasher passwordHasher;
    private final DBManager dbManager;

    public UserService() {

        this.passwordHasher = new PasswordHasher();
        this.dbManager = new DBManager();
    }

    public Optional<User> fetchUser(String email, String password) {
        try {
            String passwordHashed = this.passwordHasher.hash(password);
            ResultSet users = this.dbManager.select("SELECT id, firstname, lastname, phone, address, email, isadmin FROM customer " +
                    String.format("where email='%s' and password_hash='%s'", email, passwordHashed));
            while (users.next()) {
                User user = new User(users.getInt(1),
                        users.getString(2),
                        users.getString(3),
                        users.getString(4),
                        users.getString(5),
                        users.getString(6),
                        users.getBoolean(7));
                return Optional.of(user);
            }
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.empty();
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
                        String.format("values(%d, %d, 1)", basketId, itemId, ++currentItemsCount));
                }
            }
            else{
                if(isAdd || (!isAdd && currentItemsCount > 1))
                    this.dbManager.update("UPDATE shopping_basket_item " +
                        String.format("set count=%d ", isAdd ? ++currentItemsCount : --currentItemsCount) +
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
