package javaBean;
import services.DBManager;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ItemDB {

    private static DBManager manager = new DBManager();

    @org.jetbrains.annotations.NotNull
    public static ArrayList<Item> select(PrintWriter writer) {
        ArrayList<Item> result = new ArrayList<Item>();

        try{
            ResultSet items = manager.select("SELECT id, name, description, price FROM item");
            if(items == null)
                writer.println("items == null");
            while(items.next()){
                Item temp = new Item(items.getInt(1),
                        items.getString(2),
                        items.getString(3),
                        items.getInt(4));
                result.add(temp);
            }
        }
        catch(Exception e){
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static ArrayList<Item> selectByName(String targetName, boolean selectFirst, PrintWriter writer) {
        ArrayList<Item> result = new ArrayList<Item>();

        try{
            ResultSet items = manager.select("SELECT id, name, description, price FROM item where name = " + targetName);
            if(items == null)
                writer.println("items == null");
            while(items.next()){
                Item temp = new Item(items.getInt(1),
                        items.getString(2),
                        items.getString(3),
                        items.getInt(4));
                result.add(temp);

                if (selectFirst)
                    break;
            }
        }
        catch(Exception e){
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return result;
    }

    @org.jetbrains.annotations.NotNull
    public static void insert(Item newItem, PrintWriter writer) {
        try{
            String insertStatement = String.format("INSERT INTO item (name, description, price, created_at) Values ('%s', '%s', %s, %s)",
                    newItem.getName(), newItem.getDescription(), newItem.getPrice(), new Timestamp(System.currentTimeMillis()));

            manager.update(insertStatement);
        }
        catch(Exception e){
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }
    }

    @org.jetbrains.annotations.NotNull
    public static int update(int targetId, Item targetUpdatedItem, PrintWriter writer) {
        try{
            String updateStatement = String.format("UPDATE item SET name = '%s', description = '%s', price = %s where id = %s",
                    targetUpdatedItem.getName(), targetUpdatedItem.getDescription(), targetUpdatedItem.getPrice(), targetId);

            return manager.update(updateStatement);
        }
        catch(Exception e){
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public static int delete(int targetId, PrintWriter writer) {
        try{
            String deleteStatement = String.format("DELETE FROM item where id = %s",
                    targetId);

            return manager.update(deleteStatement);
        }
        catch(Exception e){
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public static int deleteByParams(Item targetParams, PrintWriter writer) {
        try{
            String targetName = targetParams.getName();
            String targetDes = targetParams.getDescription();
            float targetPrice = targetParams.getPrice();
            String deleteStatement = "DELETE FROM item where";
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
                return manager.update(deleteStatement);
        }
        catch(Exception e){
            writer.println(e);
            writer.println(e.getMessage());
            writer.println(e.getCause());
        }

        return 0;
    }
}