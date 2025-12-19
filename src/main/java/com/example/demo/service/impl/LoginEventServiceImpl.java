package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;

import java.util.List;

public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;
    private final RuleEvaluationUtil evaluator;

    public LoginEventServiceImpl(LoginEventRepository loginRepo,
                                 RuleEvaluationUtil evaluator) {
        this.loginRepo = loginRepo;
        this.evaluator = evaluator;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = loginRepo.save(event);
        evaluator.evaluateLoginEvent(event);
        return saved;
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginRepo.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginRepo.findByUserIdAndLoginStatus(userId, "FAILED");
    }
}
