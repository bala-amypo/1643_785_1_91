package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleService ruleService;

    public CategorizationRuleController(CategorizationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{categoryId}")
    public ResponseEntity<CategorizationRule> create(
            @PathVariable Long categoryId,
            @RequestBody CategorizationRule rule) {
        return ResponseEntity.ok(ruleService.createRule(categoryId, rule));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<CategorizationRule>> getByCategory(
            @PathVariable Long categoryId) {
        return ResponseEntity.ok(ruleService.getRulesByCategory(categoryId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorizationRule> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ruleService.getRule(id));
    }
}