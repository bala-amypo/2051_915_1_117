package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyRuleService {
    private final PolicyRuleRepository policyRuleRepository;

    public PolicyRuleService(PolicyRuleRepository policyRuleRepository) {
        this.policyRuleRepository = policyRuleRepository;
    }

    public PolicyRule createRule(PolicyRule rule) {
        return policyRuleRepository.save(rule);
    }

    public PolicyRule updateRule(Long id, PolicyRule rule) {
        policyRuleRepository.findById(id).ifPresent(existing -> {
            existing.setRuleCode(rule.getRuleCode());
            existing.setDescription(rule.getDescription());
            existing.setSeverity(rule.getSeverity());
            existing.setConditionsJson(rule.getConditionsJson());
            existing.setActive(rule.getActive());
            policyRuleRepository.save(existing);
        });
        return rule;
    }

    public List<PolicyRule> getActiveRules() {
        return policyRuleRepository.findByActiveTrue();
    }

    public Optional<PolicyRule> getRuleByCode(String ruleCode) {
        return policyRuleRepository.findAll().stream()
                .filter(rule -> ruleCode.equals(rule.getRuleCode()))
                .findFirst();
    }

    public List<PolicyRule> getAllRules() {
        return policyRuleRepository.findAll();
    }
}
