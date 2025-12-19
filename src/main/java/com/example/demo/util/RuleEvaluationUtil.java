package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository r, ViolationRecordRepository v) {
        this.ruleRepo = r;
        this.violationRepo = v;
    }

    public void evaluateLoginEvent(LoginEvent e) {
        for (PolicyRule r : ruleRepo.findByActiveTrue()) {
            if (e.getLoginStatus() != null &&
                r.getConditionsJson() != null &&
                r.getConditionsJson().contains(e.getLoginStatus())) {

                ViolationRecord v = new ViolationRecord();
                v.setSeverity(r.getSeverity());
                violationRepo.save(v);
            }
        }
    }
}
