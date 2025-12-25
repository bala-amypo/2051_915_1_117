// src/main/java/com/example/demo/service/PolicyRuleService.java
package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import java.util.List;

public interface PolicyRuleService {
    PolicyRule createRule(PolicyRule rule);
    List<PolicyRule> getAllRules();
    List<PolicyRule> getActiveRules();
}
