package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {
    private final PolicyRuleRepository policyRuleRepository;
    private final ViolationRecordRepository violationRecordRepository;

    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepository, 
                             ViolationRecordRepository violationRecordRepository) {
        this.policyRuleRepository = policyRuleRepository;
        this.violationRecordRepository = violationRecordRepository;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        policyRuleRepository.findByActiveTrue().forEach(rule -> {
            if (shouldTriggerViolation(rule, event)) {
                createViolation(event, rule);
            }
        });
    }

    private boolean shouldTriggerViolation(Object rule, LoginEvent event) {
        return true;
    }

    private void createViolation(LoginEvent event, Object rule) {
    }
}
