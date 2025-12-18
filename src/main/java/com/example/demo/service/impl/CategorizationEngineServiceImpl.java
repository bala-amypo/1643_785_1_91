package com.example.demo.service.impl;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Category;
import com.example.demo.model.Ticket;
import com.example.demo.repository.CategorizationLogRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategoryRepository categoryRepository,
            CategorizationLogRepository logRepository,
            TicketCategorizationEngine engine
    ) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }

    @Override
    public Ticket categorize(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        List<Category> categories = categoryRepository.findAll();

        engine.categorize(ticket, categories);

        return ticketRepository.save(ticket);
    }

    @Override
    public List<CategorizationLog> getLog(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}
