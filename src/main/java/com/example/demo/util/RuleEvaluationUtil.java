package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Utility class to evaluate login events against active policy rules
 * and generate violation records.
 */
public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRuleRepository;
    private final ViolationRecordRepository violationRecordRepository;

    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepository,
                              ViolationRecordRepository violationRecordRepository) {
        this.policyRuleRepository = policyRuleRepository;
        this.violationRecordRepository = violationRecordRepository;
    }

    /**
     * Evaluate a login event against all active policy rules.
     * If any rule conditions match, create a ViolationRecord.
     *
     * @param event the login event to evaluate
     */
    public void evaluateLoginEvent(LoginEvent event) {
        // Get all active rules
        List<PolicyRule> activeRules = policyRuleRepository.findByActiveTrue();

        for (PolicyRule rule : activeRules) {
            boolean violation = false;

            // Example: very simple condition check using conditionsJson string
            // In a real scenario, parse JSON and evaluate dynamically
            if (rule.getConditionsJson() != null && rule.getConditionsJson().contains("FAILED")) {
                if ("FAILED".equalsIgnoreCase(event.getLoginStatus())) {
                    violation = true;
                }
            }

            // Add more condition evaluation logic as needed

            if (violation) {
                ViolationRecord record = new ViolationRecord();
                record.setUserId(event.getUserId());
                record.setEventId(event.getId());
                record.setPolicyRuleId(rule.getId());
                record.setViolationType("LOGIN_VIOLATION");
                record.setDetails("Login failed from IP: " + event.getIpAddress() + ", Device: " + event.getDeviceId());
                record.setSeverity(rule.getSeverity());
                record.setDetectedAt(LocalDateTime.now());
                record.setResolved(false);

                violationRecordRepository.save(record);
            }
        }
    }
}
