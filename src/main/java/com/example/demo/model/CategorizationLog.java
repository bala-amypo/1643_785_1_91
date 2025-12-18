package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private CategorizationRule appliedRule;

    private String matchedKeyword;
    private String assignedCategory;
    private String assignedUrgency;

    private LocalDateTime loggedAt;

    @PrePersist
    public void onCreate() {
        loggedAt = LocalDateTime.now();
    }

    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public void setAppliedRule(CategorizationRule appliedRule) { this.appliedRule = appliedRule; }
    public void setMatchedKeyword(String matchedKeyword) { this.matchedKeyword = matchedKeyword; }
    public void setAssignedCategory(String assignedCategory) { this.assignedCategory = assignedCategory; }
    public void setAssignedUrgency(String assignedUrgency) { this.assignedUrgency = assignedUrgency; }
}
