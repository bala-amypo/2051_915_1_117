package com.example.demo.util;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository r, ViolationRecordRepository v) {
        this.ruleRepo = r;
        this.violationRepo = v;
    }

    public void evaluateLoginEvent(LoginEvent e) {
        for (PolicyRule r : ruleRepo.findByActiveTrue()) {
            if (r.getConditionsJson() != null &&
                e.getLoginStatus() != null &&
                r.getConditionsJson().contains(e.getLoginStatus())) {

                ViolationRecord vr = new ViolationRecord();
                vr.setSeverity(r.getSeverity());
                violationRepo.save(vr);
            }
        }
    }
}
