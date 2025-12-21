package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Policy Rules", description = "Manage IT policy rules")
public class PolicyRuleController {

    private final PolicyRuleRepository ruleRepo;

    public PolicyRuleController(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @PostMapping
    public ResponseEntity<PolicyRule> createRule(@RequestBody PolicyRule rule) {
        return ResponseEntity.ok(ruleRepo.save(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyRule> updateRule(@PathVariable Long id, @RequestBody PolicyRule rule) {
        PolicyRule existing = ruleRepo.findById(id).orElseThrow(() -> new RuntimeException("Rule not found"));
        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setConditionsJson(rule.getConditionsJson());
        existing.setActive(rule.getActive());
        return ResponseEntity.ok(ruleRepo.save(existing));
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> getActiveRules() {
        return ResponseEntity.ok(ruleRepo.findByActiveTrue());
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> getAllRules() {
        return ResponseEntity.ok(ruleRepo.findAll());
    }
}
