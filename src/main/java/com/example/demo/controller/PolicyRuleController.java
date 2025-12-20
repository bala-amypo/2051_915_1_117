package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }

    @PostMapping
    public ResponseEntity<PolicyRule> create(@RequestBody PolicyRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }
}
