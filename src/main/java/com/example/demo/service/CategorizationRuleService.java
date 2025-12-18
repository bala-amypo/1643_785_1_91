package com.example.demo.service;

import com.example.demo.model.CategorizationRule;
import java.util.List;

public interface CategorizationRuleService {
    CategorizationRule create(CategorizationRule rule);
    List<CategorizationRule> getAll();
}
