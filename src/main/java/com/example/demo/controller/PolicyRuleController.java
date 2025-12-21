package com.example.demo.controller;

import com.example.demo.dto.PolicyRuleDTO;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy-rules")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public PolicyRuleDTO create(@RequestBody PolicyRuleDTO dto) {
        return service.createRule(dto);
    }

    @GetMapping("/{id}")
    public PolicyRuleDTO getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping
    public List<PolicyRuleDTO> getAll() {
        return service.getAllRules();
    }

    @PutMapping("/{id}")
    public PolicyRuleDTO update(@PathVariable Long id,
                                @RequestBody PolicyRuleDTO dto) {
        return service.updateRule(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRule(id);
    }
}
