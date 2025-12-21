package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.util.RuleEvaluationUtil;
import com.example.demo.repository.LoginEventRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginEventService {
    private final LoginEventRepository loginEventRepository;
    private final RuleEvaluationUtil ruleEvaluationUtil;

    public LoginEventService(LoginEventRepository loginEventRepository, RuleEvaluationUtil ruleEvaluationUtil) {
        this.loginEventRepository = loginEventRepository;
        this.ruleEvaluationUtil = ruleEvaluationUtil;
    }

    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent savedEvent = loginEventRepository.save(event);
        ruleEvaluationUtil.evaluateLoginEvent(savedEvent);
        return savedEvent;
    }

    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginEventRepository.findAll();
    }

    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginEventRepository.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    public List<LoginEvent> getAllEvents() {
        return loginEventRepository.findAll();
    }
}
