package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/food_delivery_app"; // Replace with your DB name
    private static final String USERNAME = "root"; // Replace with your DB username
    private static final String PASSWORD = "Niharika@03"; // Replace with your DB password

    // Private constructor to prevent instantiation
    private DBConnection() {}

    // Method to get the database connection
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish the connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
