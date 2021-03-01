package DTOs;

public class ItemInBasketDTO {
    private int item_id;
    private String item_name;
    private double item_price;
    private int items_count;

    public ItemInBasketDTO(int item_id, String item_name, double item_price, int items_count) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.items_count = items_count;
    }

    public int getItemId() {
        return item_id;
    }
    public String getItemName() {
        return item_name;
    }
    public double getItemPrice() {
        return item_price;
    }
    public int getItemsCount() {
        return items_count;
    }
    public double getTotalPrice() {
        return item_price * items_count;
    }
}
