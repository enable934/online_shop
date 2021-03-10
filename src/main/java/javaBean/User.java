package javaBean;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class User {
    @Id @GeneratedValue
    private int id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "isadmin")
    private Boolean isAdmin;
    @Column(name = "password_hash")
    private String passwordHash;

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
