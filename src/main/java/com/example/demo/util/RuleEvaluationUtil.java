package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.ViolationRecord;
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
        // Simple rule evaluation - in production, parse conditionsJson
        // Example: Flag failed logins from unknown devices
        if ("FAILED".equals(event.getLoginStatus())) {
            var activeRules = policyRuleRepository.findByActiveTrue();
            for (var rule : activeRules) {
                ViolationRecord violation = new ViolationRecord(
                    event.getUserId(), 
                    rule.getId(), 
                    event.getId(),
                    "FAILED_LOGIN",
                    "Failed login from IP: " + event.getIpAddress(),
                    rule.getSeverity()
                );
                violationRecordRepository.save(violation);
            }
        }
    }
}
