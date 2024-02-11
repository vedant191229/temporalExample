package com.temporal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static Connection connection = null;

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/temporalDemo";
        String user = "root";
        String password = "Fk!@#%191229";

        // JDBC variables for opening, closing and managing connection
        try {
            // Do something with the connection
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connection obtained successfully.");
            }

        } catch (SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
        }
        return connection;
    }
}
