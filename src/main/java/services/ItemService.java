package services;

import hibernate.entity.ItemEntity;
import hibernate.entity.ItemEntity_;
import hibernate.utils.HibernateSessionFactory;
import javaBean.Item;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.awt.print.Book;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private final DBManager dbManager;

    public ItemService() {
        this.dbManager = new DBManager();
    }

    @org.jetbrains.annotations.NotNull
    public ArrayList<Item> select(PrintWriter writer) {
        ArrayList<Item> result = new ArrayList<Item>();

        try {
            ResultSet items = dbManager.select("SELECT id, name, description, price FROM item where isDeleted = false");
            if (items == null)
                writer.println("items == null");
            while (items.next()) {
                Item temp = new Item(items.getLong(1),
                        items.getString(2),
                        items.getString(3),
                        items.getFloat(4));
                result.add(temp);
            }
        } catch (Exception e) {
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return result;
    }

    public Item selectById(int targetId, PrintWriter writer) {
        Item result = null;

        try {
            ResultSet items = dbManager.select("SELECT id, name, description, price FROM item where isDeleted = false and id = " + targetId);
            if (items == null)
                writer.println("items == null");
            while (items.next()) {
                return new Item(items.getLong(1),
                        items.getString(2),
                        items.getString(3),
                        items.getInt(4));
            }
        } catch (Exception e) {
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return result;
    }

    @org.jetbrains.annotations.NotNull
    public ArrayList<Item> selectByName(String targetName, boolean selectFirst, PrintWriter writer) {
        ArrayList<Item> result = new ArrayList<Item>();

        try {
            ResultSet items = dbManager.select("SELECT id, name, description, price FROM item where isDeleted = false and name = " + targetName);
            if (items == null)
                writer.println("items == null");
            while (items.next()) {
                Item temp = new Item(items.getLong(1),
                        items.getString(2),
                        items.getString(3),
                        items.getInt(4));
                result.add(temp);

                if (selectFirst)
                    break;
            }
        } catch (Exception e) {
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return result;
    }

    @org.jetbrains.annotations.NotNull
    public int addItem(Item newItem, PrintWriter writer) {
        try {
            String insertStatement = String.format("INSERT INTO item (name, description, price, created_at) Values ('%s', '%s', %s, current_timestamp)",
                    newItem.getName(), newItem.getDescription(), newItem.getPrice());

            return dbManager.update(insertStatement);
        } catch (Exception e) {
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public int update(Item targetUpdatedItem, PrintWriter writer) {
        try {
            String updateStatement = String.format("UPDATE item SET name = '%s', description = '%s', price = %s where id = %s",
                    targetUpdatedItem.getName(), targetUpdatedItem.getDescription(), targetUpdatedItem.getPrice(), targetUpdatedItem.getId());

            return dbManager.update(updateStatement);
        } catch (Exception e) {
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public int delete(int targetId, PrintWriter writer) {
        try {
            String deleteStatement = String.format("UPDATE item SET isDeleted = true where id = %s",
                    targetId);

            return dbManager.update(deleteStatement);
        } catch (Exception e) {
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public int deleteByParams(Item targetParams, PrintWriter writer) {
        try {
            String targetName = targetParams.getName();
            String targetDes = targetParams.getDescription();
            float targetPrice = targetParams.getPrice();
            String deleteStatement = "UPDATE item SET isDeleted = true where";
            boolean executeDelete = false;

            if (!targetName.isEmpty()) {
                deleteStatement += String.format(" name = '%s'", targetName);
                executeDelete = true;
            }

            if (!targetDes.isEmpty()) {
                if (executeDelete)
                    deleteStatement += String.format(" and description = '%s'", targetDes);
                else {
                    deleteStatement += String.format(" description = '%s'", targetDes);
                    executeDelete = true;
                }
            }

            if (targetPrice != 0) {
                if (executeDelete)
                    deleteStatement += String.format(" and price = %s", targetPrice);
                else {
                    deleteStatement += String.format(" price = %s", targetPrice);
                    executeDelete = true;
                }
            }

            if (executeDelete)
                return dbManager.update(deleteStatement);
        } catch (Exception e) {
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public Long addItemViaHibernate(String name, String description, float price) {
        ItemEntity item = new ItemEntity(name, description, price);
        Long id = -1L;

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();

            id = (Long) session.save(item);

            session.getTransaction().commit();
        }

        return id;
    }

    public Boolean updateItemViaHibernate(Long id, String name, String description, float price) {
        Boolean sucess = false;

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();

            ItemEntity item = session.get(ItemEntity.class, id);

            item.setName(name);
            item.setDescription(description);
            item.setPrice(price);

            session.save(item);
            session.getTransaction().commit();

            sucess = true;
        }

        return sucess;
    }

    public Boolean deleteItemViaHibernate(Long id) {
        boolean sucess = false;

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();

            ItemEntity item = session.get(ItemEntity.class, id);
            item.setIsdeleted(true);

            session.save(item);
            session.getTransaction().commit();

            sucess = true;
        }

        return sucess;
    }

    public ItemEntity getViaHibernate(Long id) {
        ItemEntity item = null;

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();

            item = session.get(ItemEntity.class, id);
        }

        return item;
    }

    public ArrayList<ItemEntity> getAllViaHibernate() {
        ArrayList<ItemEntity> items = new ArrayList<>();

        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ItemEntity> criteria = builder.createQuery(ItemEntity.class);
            Root<ItemEntity> itemEntityRoot = criteria.from(ItemEntity.class);
            criteria.select(itemEntityRoot);
            criteria.where( builder.equal(itemEntityRoot.get(ItemEntity_.isdeleted), false));

            items = (ArrayList<ItemEntity>) session.createQuery(criteria).getResultList();
        }

        return items;
    }
}
