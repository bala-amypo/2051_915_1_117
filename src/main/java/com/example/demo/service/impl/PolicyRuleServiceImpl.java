package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;

import java.util.List;

public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository ruleRepo;

    public PolicyRuleServiceImpl(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = ruleRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setDescription(rule.getDescription());
            existing.setSeverity(rule.getSeverity());
            existing.setConditionsJson(rule.getConditionsJson());
            existing.setActive(rule.getActive());
            return ruleRepo.save(existing);
        }
        return null;
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public PolicyRule getRuleByCode(String ruleCode) {
        return ruleRepo.findAll().stream().filter(r -> r.getRuleCode().equals(ruleCode)).findFirst().orElse(null);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
