package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Policy Rules", description = "IT policy rule management")
@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {
    private final PolicyRuleService policyRuleService;

    public PolicyRuleController(PolicyRuleService policyRuleService) {
        this.policyRuleService = policyRuleService;
    }

    @PostMapping
    public PolicyRule createRule(@RequestBody PolicyRule rule) {
        return policyRuleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public PolicyRule updateRule(@PathVariable Long id, @RequestBody PolicyRule rule) {
        return policyRuleService.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<PolicyRule> getActiveRules() {
        return policyRuleService.getActiveRules();
    }

    @GetMapping
    public List<PolicyRule> getAllRules() {
        return policyRuleService.getAllRules();
    }
}
