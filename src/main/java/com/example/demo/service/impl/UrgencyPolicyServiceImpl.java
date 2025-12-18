package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.UrgencyPolicyRepository;
import com.example.demo.service.UrgencyPolicyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UrgencyPolicyServiceImpl implements UrgencyPolicyService {

    private final UrgencyPolicyRepository repo;

    public UrgencyPolicyServiceImpl(UrgencyPolicyRepository repo) {
        this.repo = repo;
    }

    public UrgencyPolicy createPolicy(UrgencyPolicy policy) {
        return repo.save(policy);
    }

    public List<UrgencyPolicy> getAllPolicies() {
        return repo.findAll();
    }

    public UrgencyPolicy getPolicy(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy not found"));
    }
}
