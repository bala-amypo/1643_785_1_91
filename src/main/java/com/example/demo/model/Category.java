package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "urgencyPolicies")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String categoryName;
    private String defaultUrgency;
    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "category_urgency_policies",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "policy_id")
    )
    private Set<UrgencyPolicy> urgencyPolicies = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public void addUrgencyPolicy(UrgencyPolicy policy) {
        if (this.urgencyPolicies == null) {
            this.urgencyPolicies = new java.util.HashSet<>();
        }
        this.urgencyPolicies.add(policy);
    }
}