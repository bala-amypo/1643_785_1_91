package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    private String description;

    @Column(nullable = false)
    private String defaultUrgency;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "assignedCategory")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "category")
    private List<CategorizationRule> rules;

    public Category() {}

    public Category(String categoryName, String defaultUrgency) {
        this.categoryName = categoryName;
        this.defaultUrgency = defaultUrgency;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public int getDefaultUrgency() { return defaultUrgency; }
    public void setDefaultUrgency(int defaultUrgency) { this.defaultUrgency = defaultUrgency; }
}