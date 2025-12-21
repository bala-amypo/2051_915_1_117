package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.util.RuleEvaluationUtil;

import java.util.List;

public class LoginEventService {

    private final LoginEventRepository loginRepo;
    private final RuleEvaluationUtil ruleUtil;

    public LoginEventService(LoginEventRepository loginRepo, RuleEvaluationUtil ruleUtil) {
        this.loginRepo = loginRepo;
        this.ruleUtil = ruleUtil;
    }

    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = loginRepo.save(event);
        ruleUtil.evaluateLoginEvent(saved);
        return saved;
    }

    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginRepo.findByUserIdAndLoginStatus(userId, "SUCCESS");
    }

    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginRepo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    public List<LoginEvent> getAllEvents() {
        return loginRepo.findAll();
    }
}
