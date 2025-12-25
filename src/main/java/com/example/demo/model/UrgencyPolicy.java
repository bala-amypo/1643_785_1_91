package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

@Entity
@Table(name = "urgency_policies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrgencyPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;
    private String keyword;
    private String urgencyOverride;
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "urgencyPolicies")
    private Set<Category> categories = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UrgencyPolicy)) return false;
        UrgencyPolicy that = (UrgencyPolicy) o;
        return java.util.Objects.equals(this.policyName, that.policyName) &&
            java.util.Objects.equals(this.keyword, that.keyword);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(policyName, keyword);
    }
}
