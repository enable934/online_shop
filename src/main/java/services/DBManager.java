package services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

    public ResultSet select(String selectQuery, PrintWriter writer) throws SQLException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        return statement.executeQuery(selectQuery);
    }

}
