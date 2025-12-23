package com.example.demo.service;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import java.util.List;
import com.example.demo.repository.CategorizationLogRepository;

public interface CategorizationEngineService {

    Ticket categorizeTicket(Long ticketId);

    CategorizationLogRepository getLogsForTicket(Long ticketId);

    CategorizationLog getLog(Long id);
}
