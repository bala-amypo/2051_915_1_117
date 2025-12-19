package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

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
        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : rules) {
            if (event.getLoginStatus() != null &&
                rule.getConditionsJson() != null &&
                rule.getConditionsJson().contains(event.getLoginStatus())) {

                ViolationRecord v = new ViolationRecord();
                v.setSeverity(rule.getSeverity());
                v.setDetails("Rule triggered: " + rule.getRuleCode());
                v.setResolved(false);

                if (event.getUserId() != null) {
                    v.setUserId(event.getUserId());
                }

                if (event.getId() != null) {
                    v.setEventId(event.getId());
                }

                violationRepo.save(v);
            }
        }
    }
}
