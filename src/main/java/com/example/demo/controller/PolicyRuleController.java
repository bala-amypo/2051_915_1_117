package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Policy Rules", description = "IT policy rule configuration")
@SecurityRequirement(name = "JWT")
public class PolicyRuleController {

    private final PolicyRuleService policyRuleService;

    public PolicyRuleController(PolicyRuleService policyRuleService) {
        this.policyRuleService = policyRuleService;
    }

    @PostMapping
    @Operation(summary = "Create new policy rule")
    public ResponseEntity<PolicyRule> createRule(@RequestBody PolicyRule rule) {
        return ResponseEntity.ok(policyRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing policy rule")
    public ResponseEntity<PolicyRule> updateRule(@PathVariable Long id,
                                                 @RequestBody PolicyRule rule) {
        PolicyRule updated = policyRuleService.updateRule(id, rule);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/active")
    @Operation(summary = "List active policy rules")
    public ResponseEntity<List<PolicyRule>> getActiveRules() {
        return ResponseEntity.ok(policyRuleService.getActiveRules());
    }

    @GetMapping
    @Operation(summary = "List all policy rules")
    public ResponseEntity<List<PolicyRule>> getAllRules() {
        return ResponseEntity.ok(policyRuleService.getAllRules());
    }

    @GetMapping("/code/{ruleCode}")
    @Operation(summary = "Get policy rule by ruleCode")
    public ResponseEntity<PolicyRule> getRuleByCode(@PathVariable String ruleCode) {
        return policyRuleService.getRuleByCode(ruleCode)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
