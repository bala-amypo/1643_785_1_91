package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorization_logs")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rule_id")
    private CategorizationRule appliedRule;

    @Column(nullable = false)
    private String matchedKeyword;

    @Column(nullable = false)
    private String assignedCategory;

    @Column(nullable = false)
    private String assignedUrgency;

    @Column(nullable = false, updatable = false)
    private LocalDateTime loggedAt;

    public CategorizationLog() {}

    public CategorizationLog(
            Ticket ticket,
            CategorizationRule appliedRule,
            String matchedKeyword,
            String assignedCategory,
            String assignedUrgency
    ) {
        this.ticket = ticket;
        this.appliedRule = appliedRule;
        this.matchedKeyword = matchedKeyword;
        this.assignedCategory = assignedCategory;
        this.assignedUrgency = assignedUrgency;
    }

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    // getters and setters
}