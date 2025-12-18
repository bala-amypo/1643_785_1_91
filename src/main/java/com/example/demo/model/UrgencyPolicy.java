package com.example.demo.model;

import jakarta.persistance.*;
import java.time.LocalDateTime;

@Entity
public class UrgencyPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Ling id;
    private String policyName;
    private String keyword;
    private String urgencyOverride;
    private LocalDateTime createdAt;
    
    @PrePersist
    void OnCreate(){
        createdAt = LocalDateTime.now();
    }
}