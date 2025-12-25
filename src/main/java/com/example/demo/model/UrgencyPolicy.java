package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "urgency_policies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UrgencyPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String keyword;
    private String urgencyOverride;
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "urgencyPolicies")
    private Set<Category> categories = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public void addCategory(Category category) {
        this.categories.add(category);
        if (!category.getUrgencyPolicies().contains(this)) {
            category.getUrgencyPolicies().add(this);
        }
    }
}
