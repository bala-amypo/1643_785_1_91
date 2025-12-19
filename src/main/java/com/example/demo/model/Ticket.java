package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    private String location;

    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category assignedCategory;

    @Column(nullable = false)
    private String urgencyLevel;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "ticket")
    private List<CategorizationLog> logs;

    public Ticket() {}

    public Ticket(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.urgencyLevel == null) {
            this.urgencyLevel = "LOW";
        }
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Category getAssignedCategory() { return assignedCategory; }
    public void setAssignedCategory(Category assignedCategory) { this.assignedCategory = assignedCategory; }

    public int getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(int urgencyLevel) { this.urgencyLevel = urgencyLevel; }

    public Integer getUrgencyOverride() { return urgencyOverride; }
    public void setUrgencyOverride(Integer urgencyOverride) { this.urgencyOverride = urgencyOverride; }
}