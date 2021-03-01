package DTOs;

import java.util.ArrayList;

public class UserBasketDTO {

    private int basket_id;
    private ArrayList<ItemInBasketDTO> items = new ArrayList<ItemInBasketDTO>();

    public UserBasketDTO(int basket_id) {
        this.basket_id = basket_id;
    }

    public int getBasketId() {
        return basket_id;
    }

    public ArrayList<ItemInBasketDTO> getItems() {
        return items;
    }

    public void addItem(ItemInBasketDTO item) { items.add(item); }

    public int getTotalCount() {
        int count = 0;
        for(ItemInBasketDTO item : items){
            count += item.getItemsCount();
        }
        return count;
    }

    public double getTotalPrice() {
        int price = 0;
        for(ItemInBasketDTO item : items){
            price += item.getTotalPrice();
        }
        return price;
    }
}
