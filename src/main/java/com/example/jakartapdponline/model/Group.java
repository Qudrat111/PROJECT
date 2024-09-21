package com.example.jakartapdponline.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
public class Group {
    private int id;
    private String name;
    private Timestamp createdAt;
    private int createdBy;
    private Timestamp updatedAt;
    private int updatedBy;
    public Group(String name, int createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }
    public Group(String name, Timestamp updatedAt, int updatedBy) {
        this.name = name;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }
}