package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginEventController {

    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    // Get all login events for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getByUserId(userId));
    }

    // Get failed login attempts for a user
    @GetMapping("/user/{userId}/failed")
    public ResponseEntity<List<LoginEvent>> getFailedLogins(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getFailedLogins(userId));
    }

    // Save a login event
    @PostMapping
    public ResponseEntity<LoginEvent> create(@RequestBody LoginEvent loginEvent) {
        return ResponseEntity.ok(loginEventService.save(loginEvent));
    }
}
