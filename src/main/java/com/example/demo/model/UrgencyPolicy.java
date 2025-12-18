package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;
    private String urgency;

    public String getKeyword() {
        return keyword;
    }

    public String getUrgency() {
        return urgency;
    }
}
