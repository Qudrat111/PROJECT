package com.example.jakartapdponline.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "students", schema = "orm")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int group_id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private Date dateOfBirth;
    private Timestamp createdAt;
    private int createdBy;
    private Timestamp updatedAt;
    private int updatedBy;

    public Student(int group_id, String userName, String fullName, Date dateOfBirth, int createdBy) {
        this.group_id = group_id;
        this.userName = userName;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.createdBy = createdBy;
    }

    public Student(int group_id, String userName, String fullName, Date dateOfBirth, Timestamp updatedAt, int updatedBy) {
        this.group_id = group_id;
        this.userName = userName;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }
}