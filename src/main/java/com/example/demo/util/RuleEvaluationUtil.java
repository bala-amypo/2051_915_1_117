package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;

public class RuleEvaluationUtil {

    public static boolean evaluate(LoginEvent event, PolicyRule rule) {

        if (rule.getRuleType().equalsIgnoreCase("LOGIN_SUCCESS")) {
            return Boolean.TRUE.equals(event.getSuccess());
        }

        if (rule.getRuleType().equalsIgnoreCase("LOGIN_FAILURE")) {
            return Boolean.FALSE.equals(event.getSuccess());
        }

        return true;
    }
}
