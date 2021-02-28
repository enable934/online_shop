package services;

import javaBean.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserService {
    private final PasswordHasher passwordHasher;
    private final DBManager dbManager;

    public UserService() {

        this.passwordHasher = new PasswordHasher();
        this.dbManager = new DBManager();
        ;
    }

    public Optional<User> fetchUser(String email, String password) {
        try {
            String passwordHashed = this.passwordHasher.hash(password);
            ResultSet users = this.dbManager.select("SELECT firstname, lastname, phone, address, email, isadmin FROM customer " +
                    String.format("where email='%s' and password_hash='%s'", email, passwordHashed));
            while (users.next()) {
                User user = new User(users.getString(1),
                        users.getString(2),
                        users.getString(3),
                        users.getString(4),
                        users.getString(5),
                        users.getBoolean(6)
                );
                return Optional.of(user);
            }
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.empty();
    }

    public int registerNewUser(String firstname, String lastname, String email, String password) {
        try {
            String passwordHashed = this.passwordHasher.hash(password);
            String query = String.format("insert into customer(firstname, lastname, password_hash, email) values ('%s', '%s', '%s', '%s')", firstname, lastname, passwordHashed, email);

            return this.dbManager.update(query);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
            return 0;
        }
    }
    }
