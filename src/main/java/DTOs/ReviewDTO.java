package DTOs;

import java.sql.Timestamp;

public class ReviewDTO {

    private int id;
    private int item_id;
    private String customer_name;
    private int rate_score;
    private Timestamp date;
    private String text;

    public ReviewDTO() {
        this.id = 0;
        this.item_id = 0;
        this.customer_name = "";
        this.rate_score = 0;
        this.date = new Timestamp(System.currentTimeMillis());
        this.text = "";
    }

    public ReviewDTO(int id, int item_id, String customer_name, int rate_score, Timestamp date, String text) {
        this.id = id;
        this.item_id = item_id;
        this.customer_name = customer_name;
        this.rate_score = rate_score;
        this.date = date;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getRate_score() {
        return rate_score;
    }

    public void setRate_score(int rate_score) {
        this.rate_score = rate_score;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
