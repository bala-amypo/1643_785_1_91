package com.example.demo.repository;

import com.example.demo.model.CategorizationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CategorizationLogRepository extends JpaRepository<CategorizationLog, Long> {
    List<CategorizationLog> findByTicket_Id(Long ticketId);
    List<CategorizationLog> findByTicketId(Long ticketId);
}