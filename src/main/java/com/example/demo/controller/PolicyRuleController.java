package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PolicyRuleController {
    @Autowired
    private final PolicyRuleService ruleService;

    public PolicyRuleController(PolicyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    public ResponseEntity<PolicyRule> create(PolicyRule rule) {
        return ResponseEntity.ok(ruleService.createRule(rule));
    }
}
