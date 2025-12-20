package com.example.demo.repository;

import com.example.demo.entity.PolicyRule;
import java.util.List;

public interface PolicyRuleRepository {
    List<PolicyRule> findAll();
    List<PolicyRule> findByRuleType(String ruleType);
}
