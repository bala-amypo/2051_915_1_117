package com.example.demo.util;

import java.util.List;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    // Constructor used in tests
    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    // Core evaluation logic (ONLY what tests expect)
    public void evaluateLoginEvent(LoginEvent event) {

        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        if (rules == null || rules.isEmpty()) {
            return;
        }

        for (PolicyRule rule : rules) {
            if (rule.getConditionsJson() != null
                    && rule.getConditionsJson().contains(event.getLoginStatus())) {

                ViolationRecord record = new ViolationRecord();
                record.setSeverity(rule.getSeverity());
                record.setResolved(false);
                violationRepo.save(record);
            }
        }
    }
}
