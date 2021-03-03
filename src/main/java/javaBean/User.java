package javaBean;
import javax.ejb.EntityBean;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Column(name = "id")
    private final int id;
    @Column(name = "firstname")
    private final String firstname;
    @Column(name = "lastname")
    private final String lastname;
    @Column(name = "phone")
    private final String phone;
    @Column(name = "address")
    private final String address;
    @Column(name = "email")
    private final String email;
    @Column(name = "isadmin")
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
