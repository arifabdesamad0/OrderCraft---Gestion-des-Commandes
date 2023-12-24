package org.titans.util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/artwood";
    private static java.sql.Connection connection = null;

    public static java.sql.Connection getConnectionDB() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error In DB");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
