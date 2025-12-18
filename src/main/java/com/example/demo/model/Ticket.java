package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    private Category category;

    private String urgency;

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getDescription() {
        return description;
    }
}
