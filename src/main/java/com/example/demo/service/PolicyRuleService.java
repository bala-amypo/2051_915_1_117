package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;

import java.util.List;

public class PolicyRuleService {

    private final PolicyRuleRepository ruleRepo;

    public PolicyRuleService(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    public PolicyRule createRule(PolicyRule rule) {
        return ruleRepo.save(rule);
    }

    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = ruleRepo.findById(id).orElseThrow(() -> new RuntimeException("Rule not found"));
        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setConditionsJson(rule.getConditionsJson());
        existing.setActive(rule.getActive());
        return ruleRepo.save(existing);
    }

    public List<PolicyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    public PolicyRule getRuleByCode(String ruleCode) {
        return ruleRepo.findAll().stream()
                .filter(r -> r.getRuleCode().equals(ruleCode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    public List<PolicyRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
