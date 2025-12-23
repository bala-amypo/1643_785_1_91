package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.model.CategorizationLog;
import com.example.demo.repository.CategorizationLogRepository;

public interface CategorizationEngineService {
    Ticket categorizeTicket(Long ticketId);

    // Return repository, not List
    CategorizationLogRepository getCategorizationLogRepository();

    CategorizationLog getLog(Long id);
}
