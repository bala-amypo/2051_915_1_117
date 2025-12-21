package com.example.demo.service;

import com.example.demo.entity.PolicyRule;

import java.util.List;

public interface PolicyRuleService {

    PolicyRule saveRule(PolicyRule rule);

    List<PolicyRule> getAllRules();
}
