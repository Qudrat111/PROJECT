package com.example.jakartapdponline.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private int id;
    private int group_id;
    private String userName;
    private String fullName;
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
