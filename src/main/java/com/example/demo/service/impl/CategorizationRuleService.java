package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Category;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    private final CategorizationRuleRepository ruleRepo;
    private final CategoryRepository categoryRepo;

    public CategorizationRuleServiceImpl(
            CategorizationRuleRepository ruleRepo,
            CategoryRepository categoryRepo) {
        this.ruleRepo = ruleRepo;
        this.categoryRepo = categoryRepo;
    }

    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));
        rule.setCategory(category);
        return ruleRepo.save(rule);
    }

    public List<CategorizationRule> getRulesByCategory(Long categoryId) {
        return ruleRepo.findAll();
    }

    public CategorizationRule getRule(Long id) {
        return ruleRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found"));
    }
}
