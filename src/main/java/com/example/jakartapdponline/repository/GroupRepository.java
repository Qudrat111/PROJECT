package com.example.jakartapdponline.repository;

import com.example.jakartapdponline.model.Group;
import com.example.jakartapdponline.prop.DataBaseProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupRepository {
    Connection conn;

    public GroupRepository() {
        conn = DataBaseProperties.getConnection();
    }

    public void insertGroup(Group group) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("insert into groups (name,created_by) values " +
                "(?,?)")) {
            preparedStatement.setString(1, group.getName());
            preparedStatement.setInt(2, group.getCreatedBy());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGroup(int id, Group group) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("update groups set " +
                "name = ?," +
                "updated_at = ?," +
                "updated_by = ? where id = ?")) {
            preparedStatement.setString(1, group.getName());
            preparedStatement.setTimestamp(2, group.getUpdatedAt());
            preparedStatement.setInt(3, group.getUpdatedBy());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGroup(int id) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("delete from groups where id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<List<Group>> getAll() {
        List<Group> groups = new ArrayList<>();
        try (PreparedStatement preparedStatement = conn.prepareStatement("select * from groups");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("name"));
                groups.add(group);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(groups);
    }
}
