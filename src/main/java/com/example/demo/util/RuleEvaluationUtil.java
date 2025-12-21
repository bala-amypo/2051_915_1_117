package com.example.demo.util;

import com.example.demo.entity.LoginEvent;

public class RuleEvaluationUtil {

    private RuleEvaluationUtil() {
    }

    // Example rule: check failed login
    public static boolean isFailedLogin(LoginEvent event) {
        return !event.isSuccess();
    }

    // Example rule: suspicious login
    public static boolean isSuspicious(LoginEvent event) {
        if (!event.isSuccess()) {
            return event.getIpAddress() != null && event.getDeviceId() != null;
        }
        return false;
    }
}
