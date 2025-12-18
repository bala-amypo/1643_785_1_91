package com.example.demo.model;

import jakarta.persistance.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Ling id;
    @ManyToOne
    private Category category;
    private String keyword;
    private String matchType;
    private Integer priority;
    private LocalDateTime createdAt;
    
    @PrePersist
    void OnCreate(){
        createdAt = LocalDateTime.now();
    }
}