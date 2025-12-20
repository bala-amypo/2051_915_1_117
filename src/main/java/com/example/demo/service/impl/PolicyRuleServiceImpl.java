package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;

import java.util.List;

public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repository;

    public PolicyRuleServiceImpl(PolicyRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }
}
