package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface CategorizationRuleService {
    CategorizationRule createRule(CategorizationRule rule);
    CategorizationRule getRule(Long id);
    List<CategorizationRule> getAllRules();
    List<CategorizationRule> searchByKeyword(String keyword);
    void deleteRule(Long id);
}