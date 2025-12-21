package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

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
        // Fetch active rules
        List<PolicyRule> rules = policyRuleRepository.findByActiveTrue();

        for (PolicyRule rule : rules) {
            // Simple example: if login is FAILED, create a violation
            if ("FAILED".equalsIgnoreCase(event.getLoginStatus())) {
                ViolationRecord violation = new ViolationRecord();
                violation.setUserId(event.getUserId());
                violation.setEventId(event.getId());
                violation.setPolicyRuleId(rule.getId());
                violation.setViolationType("LOGIN_FAILURE");
                violation.setDetails("Failed login detected");
                violation.setSeverity(rule.getSeverity());
                violation.setDetectedAt(LocalDateTime.now());
                violation.setResolved(false);
                violationRecordRepository.save(violation);
            }
        }
    }
}
