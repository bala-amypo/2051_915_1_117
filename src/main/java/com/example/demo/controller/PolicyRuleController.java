package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Policy Rules", description = "Manage IT policy rules")
public class PolicyRuleController {

    private final PolicyRuleService ruleService;

    public PolicyRuleController(PolicyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public ResponseEntity<PolicyRule> createRule(@RequestBody PolicyRule rule) {
        ruleService.createRule(rule);
        return ResponseEntity.ok(rule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyRule> updateRule(@PathVariable Long id, @RequestBody PolicyRule rule) {
        ruleService.updateRule(id, rule);
        return ResponseEntity.ok(rule);
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> getActiveRules() {
        return ResponseEntity.ok(ruleService.getActiveRules());
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }
}
