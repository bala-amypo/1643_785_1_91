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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category assignedCategory;

    @Column(nullable = false)
    private String assignedUrgency;

    @Column(nullable = false, updatable = false)
    private LocalDateTime loggedAt;

    public CategorizationLog() {}

    public CategorizationLog(
            Ticket ticket,
            CategorizationRule appliedRule,
            String matchedKeyword,
            Category assignedCategory,
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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }

    public CategorizationRule getAppliedRule() { return appliedRule; }
    public void setAppliedRule(CategorizationRule appliedRule) { this.appliedRule = appliedRule; }

    public String getMatchedKeyword() { return matchedKeyword; }
    public void setMatchedKeyword(String matchedKeyword) { this.matchedKeyword = matchedKeyword; }

    public Category getAssignedCategory() { return assignedCategory; }
    public void setAssignedCategory(Category assignedCategory) { this.assignedCategory = assignedCategory; }

    public String getAssignedUrgency() { return assignedUrgency; }
    public void setAssignedUrgency(String assignedUrgency) { this.assignedUrgency = assignedUrgency; }

    public LocalDateTime getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
}