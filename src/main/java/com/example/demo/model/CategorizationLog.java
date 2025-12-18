package com.example.demo.model;

import jakarta.persistance.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Ling id;
    @ManyToOne
    private CategorizationRule appliedRule;
    private String matchedKeyword;
    private String assignedCategory;
    private String assignedUrgency;
    private LocalDateTime loggedAt;
    
    @PrePersist
    void OnCreate(){
        loogedAt = LocalDateTime.now();
    }
}