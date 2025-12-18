package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategorizationEngineServiceImpl
        implements CategorizationEngineService {

    private final TicketRepository ticketRepo;
    private final CategoryRepository categoryRepo;
    private final CategorizationRuleRepository ruleRepo;
    private final UrgencyPolicyRepository policyRepo;
    private final CategorizationLogRepository logRepo;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepo,
            CategoryRepository categoryRepo,
            CategorizationRuleRepository ruleRepo,
            UrgencyPolicyRepository policyRepo,
            CategorizationLogRepository logRepo,
            TicketCategorizationEngine engine) {

        this.ticketRepo = ticketRepo;
        this.categoryRepo = categoryRepo;
        this.ruleRepo = ruleRepo;
        this.policyRepo = policyRepo;
        this.logRepo = logRepo;
        this.engine = engine;
    }

    public Ticket categorizeTicket(Long ticketId) {

        Ticket ticket = ticketRepo.findById(ticketId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ticket not found"));

        List<CategorizationLog> logs = new ArrayList<>();

        engine.categorize(
                ticket,
                categoryRepo.findAll(),
                ruleRepo.findAll(),
                policyRepo.findAll(),
                logs
        );

        ticketRepo.save(ticket);
        logRepo.saveAll(logs);

        return ticket;
    }

    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepo.findByTicket_Id(ticketId);
    }

    public CategorizationLog getLog(Long id) {
        return logRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Log not found"));
    }
}
