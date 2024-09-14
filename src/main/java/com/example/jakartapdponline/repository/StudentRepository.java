package com.example.jakartapdponline.repository;

import com.example.jakartapdponline.model.Student;
import com.example.jakartapdponline.prop.DataBaseProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    private Connection conn;

    public StudentRepository() {
        conn = DataBaseProperties.getConnection();
    }

    public void insertStudent(Student student) {
        try (PreparedStatement ps = conn.prepareStatement("" +
                "insert into " +
                "students(group_id,full_name,user_name,dob,created_by) values " +
                "(?,?,?,?,?)")) {
            ps.setInt(1, student.getGroup_id());
            ps.setString(2, student.getFullName());
            ps.setString(3, student.getUserName());
            ps.setDate(4, student.getDateOfBirth());
            ps.setInt(5, student.getCreatedBy());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateStudent(Integer studentId, Student student) {
        try (PreparedStatement ps = conn.prepareStatement("update students set " +
                "group_id = ?," +
                "full_name = ?," +
                "user_name = ?," +
                "dob = ?," +
                "updated_at = ?," +
                "updated_by = ? " +
                "where id = ?")) {
            ps.setInt(1, student.getGroup_id());
            ps.setString(2, student.getFullName());
            ps.setString(3, student.getUserName());
            ps.setDate(4, student.getDateOfBirth());
            ps.setTimestamp(5, student.getUpdatedAt());
            ps.setInt(6, student.getUpdatedBy());
            ps.setInt(7, studentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStudent(Integer studentId) {
        try (PreparedStatement ps = conn.prepareStatement("delete from students where id = ?")) {
            ps.setInt(1, studentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (PreparedStatement ps = conn.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFullName(resultSet.getString("full_name"));
                student.setUserName(resultSet.getString("user_name"));
                student.setGroup_id(resultSet.getInt("group_id"));
                student.setDateOfBirth(resultSet.getDate("dob"));
                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving students", e);
        }

        return Optional.ofNullable(students);
    }
}
