package javaBean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Review implements Serializable {

    private int id;
    private int item_id;
    private int customer_id;
    private int rate_score;
    private Timestamp date;
    private String text;

    public Review() {
        this.id = 0;
        this.item_id = 0;
        this.customer_id = 0;
        this.rate_score = 0;
        this.date = new Timestamp(System.currentTimeMillis());
        this.text = "";
    }

    public Review(int id, int item_id, int customer_id, int rate_score, String text) {
        this.id = id;
        this.item_id = item_id;
        this.customer_id = customer_id;
        this.rate_score = rate_score;
        this.date = new Timestamp(System.currentTimeMillis());
        this.text = text;
    }

    public Review(int id, int item_id, int customer_id, int rate_score, Timestamp date, String text) {
        this.id = id;
        this.item_id = item_id;
        this.customer_id = customer_id;
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

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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