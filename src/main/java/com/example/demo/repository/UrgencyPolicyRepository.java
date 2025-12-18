package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrgencyPolicyRepository extends JpaRepository<UrgencyPolicy, Long> {
    List<UrgencyPolicy> findByKeywordContainingIgnoreCase(String keyword);
}