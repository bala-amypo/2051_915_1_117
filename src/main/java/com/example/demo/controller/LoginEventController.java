package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService loginEventService;
    private final RuleEvaluationUtil ruleEvaluationUtil;

    public LoginEventController(LoginEventService loginEventService,
                                RuleEvaluationUtil ruleEvaluationUtil) {
        this.loginEventService = loginEventService;
        this.ruleEvaluationUtil = ruleEvaluationUtil;
    }

    @PostMapping("/record")
    public LoginEvent recordLogin(@RequestBody LoginEvent event) {
        LoginEvent savedEvent = loginEventService.recordLogin(event);
        ruleEvaluationUtil.evaluateLoginEvent(savedEvent);
        return savedEvent;
    }
}
