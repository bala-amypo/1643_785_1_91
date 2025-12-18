package com.example.demo.model;

import jakarta.persistance.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Ling id;
    private String title;
    private String description;
    private String location;
    private String createdBy;
    @ManyToOne
    private Category assignedCategory;
    private String u
    
    @PrePersist
    voidOnCreate(){
        createdAt = LocalDateTime.now();
    }
}