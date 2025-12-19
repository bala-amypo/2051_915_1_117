package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        for (PolicyRule rule : ruleRepo.findByActiveTrue()) {
            if (rule.getConditionsJson() != null &&
                event.getLoginStatus() != null &&
                rule.getConditionsJson().contains(event.getLoginStatus())) {

                ViolationRecord v = new ViolationRecord();
                v.setSeverity(rule.getSeverity());
                v.setDetails("Policy violation detected");

                violationRepo.save(v);
            }
        }
    }
}
