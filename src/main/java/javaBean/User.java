package javaBean;

public class User {
    private final String firstname;
    private final String lastname;
    private final String phone;
    private final String address;
    private final String email;

    public User(String firstname, String lastname, String phone, String address, String email){

        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.email = email;
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
}
