package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorizationLogRepository extends JpaRepository<CategorizationLog, Long> {
    List<CategorizationRule> findByTicket_Id(Long ticketId);
}