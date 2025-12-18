package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    private final CategorizationRuleRepository repo;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public CategorizationRule create(CategorizationRule rule) {
        return repo.save(rule);
    }

    @Override
    public List<CategorizationRule> getAll() {
        return repo.findAll();
    }
}
