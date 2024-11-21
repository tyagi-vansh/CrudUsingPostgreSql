package com.example.CrudUsingPostgre.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "userdetails")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String mobile;
}
