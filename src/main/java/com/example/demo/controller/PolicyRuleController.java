package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PolicyRuleController {

    private final PolicyRuleService ruleService;

    public PolicyRuleController(PolicyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    // Used in testRuleControllerList()
    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    // Optional
    public ResponseEntity<PolicyRule> create(PolicyRule rule) {
        return ResponseEntity.ok(ruleService.createRule(rule));
    }
}
