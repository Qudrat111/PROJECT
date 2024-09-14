package com.example.jakartapdponline.prop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseProperties {
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:postgresql://localhost:5432/pdp_online";


    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
