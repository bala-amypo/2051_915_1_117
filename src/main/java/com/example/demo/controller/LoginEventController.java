package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/logins")
@Tag(name = "Login Events", description = "Manage login events and suspicious activities")
public class LoginEventController {

    private final LoginEventRepository loginRepo;
    private final RuleEvaluationUtil ruleUtil;

    public LoginEventController(LoginEventRepository loginRepo, RuleEvaluationUtil ruleUtil) {
        this.loginRepo = loginRepo;
        this.ruleUtil = ruleUtil;
    }

    @PostMapping("/record")
    public ResponseEntity<LoginEvent> recordLogin(@RequestBody LoginEvent event) {
        LoginEvent saved = loginRepo.save(event);
        ruleUtil.evaluateLoginEvent(saved);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getEventsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loginRepo.findByUserIdAndLoginStatus(userId, "SUCCESS"));
    }

    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> getSuspiciousLogins(@PathVariable Long userId) {
        return ResponseEntity.ok(loginRepo.findByUserIdAndLoginStatus(userId, "FAILED"));
    }

    @GetMapping
    public ResponseEntity<List<LoginEvent>> getAllEvents() {
        return ResponseEntity.ok(loginRepo.findAll());
    }
}
