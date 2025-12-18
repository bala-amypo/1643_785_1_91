package com.example.demo.controller;

import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorize")
public class CategorizationEngineController {

    private final CategorizationEngineService service;

    public CategorizationEngineController(CategorizationEngineService service) {
        this.service = service;
    }

    @PostMapping("/run/{ticketId}")
    public ResponseEntity<Ticket> categorize(@PathVariable Long ticketId) {
        return ResponseEntity.ok(service.categorizeTicket(ticketId));
    }

    @GetMapping("/logs/{ticketId}")
    public ResponseEntity<List<CategorizationLog>> getLogs(@PathVariable Long ticketId) {
        return ResponseEntity.ok(service.getLogsForTicket(ticketId));
    }

    @GetMapping("/log/{id}")
    public ResponseEntity<CategorizationLog> getLog(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLog(id));
    }
}
