package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
}

public interface TicketRepository extends JpaRepository<Ticket, Long> {}

public interface CategoryRepository extends JpaRepository<Category, Long> {}

public interface CategorizationRuleRepository extends JpaRepository<CategorizationRule, Long> {
    List<CategorizationRule> findByKeywordContainingIgnoreCase(String keyword);
}

public interface UrgencyPolicyRepository extends JpaRepository<UrgencyPolicy, Long> {
    List<UrgencyPolicy> findByKeywordContainingIgnoreCase(String keyword);
}

public interface CategorizationLogRepository extends JpaRepository<CategorizationLog, Long> {
    List<CategorizationLog> findByTicket_Id(Long ticketId);
}
