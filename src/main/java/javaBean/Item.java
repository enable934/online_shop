package javaBean;

import java.io.Serializable;

public class Item implements Serializable {

    private Long id;
    private String name;
    private String description;
    private float price;

    public Item() {
        this.id = 0L;
        this.name = "";
        this.description = "";
        this.price = 0;
    }

    public Item(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Item(Long id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item that = (Item) o;

        if (price != that.getPrice()) return false;
        if (id != null ? !id.equals(that.getId()) : that.getId() != null) return false;
        if (name != null ? !name.equals(that.getName()) : that.getName() != null) return false;
        if (description != null ? !description.equals(that.getDescription()) : that.getDescription() != null) return false;

        return true;
    }
}