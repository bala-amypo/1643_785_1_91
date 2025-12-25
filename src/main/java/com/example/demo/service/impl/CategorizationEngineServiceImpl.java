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
public class CategorizationEngineServiceImpl implements CategorizationEngineService {
    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository policyRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(TicketRepository tr, CategoryRepository cr, 
            CategorizationRuleRepository rr, UrgencyPolicyRepository pr, 
            CategorizationLogRepository lr, TicketCategorizationEngine engine) {
        this.ticketRepository = tr;
        this.categoryRepository = cr;
        this.ruleRepository = rr;
        this.policyRepository = pr;
        this.logRepository = lr;
        this.engine = engine;
    }

    @Override
    public Ticket categorizeTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
            .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        List<Category> categories = categoryRepository.findAll();
        List<CategorizationRule> rules = ruleRepository.findAll();
        List<UrgencyPolicy> policies = policyRepository.findAll();
        List<CategorizationLog> logs = new ArrayList<>();

        engine.categorize(ticket, categories, rules, policies, logs);

        logRepository.saveAll(logs);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }

    @Override
    public CategorizationLog getLog(Long id) {
        return logRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}