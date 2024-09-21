package com.example.jakartapdponline.repository;

import com.example.jakartapdponline.model.User;

import java.sql.*;

public class AuthRepository {
    Connection conn;

    public AuthRepository() {
        try {
            Class.forName("org.postgresql.Driver");
            String DB_URL = "jdbc:postgresql://localhost:5432/pdp_online";
            String USER = "postgres";
            String PASSWORD = "1234";
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserByUsername(String username) {
        User user = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement("select * from users.users where username = ?")) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setUser_id(resultSet.getInt("user_id"));
                user.setPassword(resultSet.getString("password"));
            }
            return user;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addUser(User user) {
        try (PreparedStatement ps = conn.prepareStatement("insert into users.users(username,password) values (?,?)")) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
