// src/main/java/com/example/demo/util/RuleEvaluationUtil.java
package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
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
            if (rule.getConditionsJson() != null && rule.getConditionsJson().contains(event.getLoginStatus())) {
                ViolationRecord violation = new ViolationRecord();
                violation.setUserId(event.getUserId());
                violation.setEventId(event.getId());
                violation.setSeverity(rule.getSeverity());
                violation.setDetails("Violation triggered by rule: " + rule.getRuleCode());
                violation.setResolved(false);
                violation.setCreatedAt(LocalDateTime.now());
                violationRepo.save(violation);
            }
        }
    }
}
