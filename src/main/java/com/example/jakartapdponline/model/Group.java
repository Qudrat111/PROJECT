package com.example.jakartapdponline.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "orm",name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
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