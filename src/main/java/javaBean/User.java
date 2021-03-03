package javaBean;
import javax.ejb.EntityBean;

import javax.persistence.*;

@Entity
@Table
public class User {
    private final int id;
    private final String firstname;
    private final String lastname;
    private final String phone;
    private final String address;
    private final String email;
    private final Boolean isAdmin;

    public User(int id, String firstname, String lastname, String phone, String address, String email, Boolean isAdmin){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }
}
