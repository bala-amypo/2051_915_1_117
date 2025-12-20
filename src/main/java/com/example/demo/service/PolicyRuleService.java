package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.entity.PolicyRule;
import java.util.List;
@Service
public interface PolicyRuleService {

    PolicyRule createRule(PolicyRule rule);

    List<PolicyRule> getAllRules();

    List<PolicyRule> getActiveRules();
}
