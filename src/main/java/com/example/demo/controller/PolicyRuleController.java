// src/main/java/com/example/demo/controller/PolicyRuleController.java
package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {
    private final PolicyRuleService ruleService;

    public PolicyRuleController(PolicyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public ResponseEntity<PolicyRule> create(@RequestBody PolicyRule rule) {
        PolicyRule saved = ruleService.createRule(rule);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> all() {
        List<PolicyRule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> active() {
        List<PolicyRule> rules = ruleService.getActiveRules();
        return ResponseEntity.ok(rules);
    }
}
