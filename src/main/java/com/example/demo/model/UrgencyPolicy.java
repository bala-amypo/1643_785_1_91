package com.example.demo.model;

import jakarta.persistance.*;
import java.time.LocalDateTime;

@Entity
public class UrgencyPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Ling id;

    private String policyName;
    private String key;
    private String location;
    private String createdBy;
    @ManyToOne
    private Category assignedCategory;
    private String urgencyLevel;
    private LocalDateTime createdAt;
    
    @PrePersist
    void OnCreate(){
        createdAt = LocalDateTime.now();
    }
}