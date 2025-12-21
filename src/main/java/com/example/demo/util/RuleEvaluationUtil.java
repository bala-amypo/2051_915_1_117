package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

import java.time.LocalDateTime;
import java.util.List;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();
        for (PolicyRule rule : activeRules) {
            if ("FAILED".equals(event.getLoginStatus())) {
                ViolationRecord record = new ViolationRecord();
                record.setUserId(event.getUserId());
                record.setEventId(event.getId());
                record.setPolicyRuleId(rule.getId());
                record.setViolationType("FAILED_LOGIN");
                record.setDetails("Login failed from IP: " + event.getIpAddress());
                record.setSeverity(rule.getSeverity());
                record.setDetectedAt(LocalDateTime.now());
                violationRepo.save(record);
            }
        }
    }
}
