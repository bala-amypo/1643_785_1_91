package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "urgency_policies")
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String urgencyOverride;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public UrgencyPolicy() {}

    public UrgencyPolicy(String keyword, String urgencyOverride) {
        this.keyword = keyword;
        this.urgencyOverride = urgencyOverride;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }


    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public int getUrgencyOverride() { return urgencyOverride; }
    public void setUrgencyOverride(int urgencyOverride) { this.urgencyOverride = urgencyOverride; }
}