package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.CategorizationEngineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorize")
@Tag(name = "Categorization Engine")
public class CategorizationEngineController {

    private final CategorizationEngineService service;

    public CategorizationEngineController(CategorizationEngineService service) {
        this.service = service;
    }

    @PostMapping("/run/{ticketId}")
    public Ticket run(@PathVariable Long ticketId) {
        return service.categorizeTicket(ticketId);
    }

    @GetMapping("/logs/{ticketId}")
    public List<CategorizationLog> logs(@PathVariable Long ticketId) {
        return service.getLogsForTicket(ticketId);
    }

    @GetMapping("/log/{id}")
    public CategorizationLog log(@PathVariable Long id) {
        return service.getLog(id);
    }
}
