package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;

import java.util.List;

public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;
    private final RuleEvaluationUtil ruleEvalUtil;

    public LoginEventServiceImpl(LoginEventRepository loginRepo, RuleEvaluationUtil ruleEvalUtil) {
        this.loginRepo = loginRepo;
        this.ruleEvalUtil = ruleEvalUtil;
    }

    @Override
    public void recordLogin(LoginEvent event) {
        loginRepo.save(event);
        ruleEvalUtil.evaluateLoginEvent(event);
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginRepo.findByUserIdAndLoginStatus(userId, "SUCCESS");
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginRepo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return loginRepo.findAll();
    }
}
