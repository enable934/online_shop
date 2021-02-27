package services;

import javaBean.User;

import java.sql.ResultSet;
import java.util.Optional;

public class UserService {
    private final PasswordHasher passwordHasher;
    private final DBManager dbManager;

    public UserService(){

        this.passwordHasher = new PasswordHasher();
        this.dbManager = new DBManager();;
    }
    public Optional<User> fetchUser(String email, String password){
        try{
            String passwordHashed = this.passwordHasher.hash(password);
            ResultSet users = this.dbManager.select("SELECT firstname, lastname, phone, address, email FROM customer " +
                    String.format("where email='%s' and password_hash='%s'",email, passwordHashed));
            while(users.next()){
                User user = new User(users.getString(1),
                        users.getString(2),
                        users.getString(3),
                        users.getString(4),
                        users.getString(5));
                return Optional.of(user);
            }
        }
        catch(Exception e){
            return Optional.empty();
        }

        return Optional.empty();
    }
}
