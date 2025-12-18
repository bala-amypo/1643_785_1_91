package com.example.demo.model;

import jakarta.persistance.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Ling id;
    @Column(unique = true)
    private String categoryName;
    private String description;
    private String defaultUrgency;
    private LocalDateTime createdAt;
    @PrePersist
    voidOnCreate(){
        createdAt = LocalDateTime.now();
    }
}