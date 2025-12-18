package com.example.demo.service;

import com.example.demo.model.CategorizationRule;

public interface CategorizationRuleService {
    CategorizationRule create(CategorizationRule rule, Long categoryId);
}
