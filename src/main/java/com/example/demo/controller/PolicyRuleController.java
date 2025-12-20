package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;

public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }

    public ResponseEntity<PolicyRule> create(PolicyRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }
}
