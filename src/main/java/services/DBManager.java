package services;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DBManager {
    protected Connection getConnection() throws ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String url = "jdbc:postgresql://host.docker.internal:5432/online_shop?user=root&password=";
        String username = "root";
        String password = "";
        Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection(url, username, password);
    }

    public ResultSet select(String selectQuery) throws SQLException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(selectQuery);
        conn.close();

        return result;
    }

    // In this perfect language executeUpdate used for INSERT/UPDATE/DELETE ...
    public int update(String updateQuery) throws SQLException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        int result = statement.executeUpdate(updateQuery);
        conn.close();

        return result;
    }

}
