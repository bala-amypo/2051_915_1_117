package com.example.demo.service;

import com.example.demo.entity.PolicyRule;

import java.util.List;
import java.util.Optional;

public interface PolicyRuleService {

    PolicyRule createRule(PolicyRule rule);

    List<PolicyRule> getActiveRules();

    List<PolicyRule> getAllRules();

    Optional<PolicyRule> getRuleByCode(String ruleCode);
}
