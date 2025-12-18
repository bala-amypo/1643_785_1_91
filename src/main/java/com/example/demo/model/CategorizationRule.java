package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    @Enumerated(EnumType.STRING)
    private MatchType matchType;

    @ManyToOne
    private Category category;

    public String getKeyword() {
        return keyword;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public Category getCategory() {
        return category;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
