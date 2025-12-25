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

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : activeRules) {
            // Simple condition: if rule.conditionsJson contains "FAILED"
            // and login status is FAILED, trigger a violation.
            if (event.getLoginStatus() != null
                    && "FAILED".equalsIgnoreCase(event.getLoginStatus())
                    && rule.getConditionsJson() != null
                    && rule.getConditionsJson().contains("FAILED")) {

                ViolationRecord v = new ViolationRecord();
                v.setUserId(event.getUserId());
                v.setEventId(event.getId());
                v.setSeverity(rule.getSeverity());
                v.setDetails("Rule triggered for login failure");
                v.setResolved(false);
                v.setCreatedAt(LocalDateTime.now());

                violationRepo.save(v);
            }
        }
    }
}
`