package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;


import org.springframework.http.ResponseEntity;


import java.util.List;

public class LoginEventController {
  
    private final LoginEventService loginService;

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    public ResponseEntity<LoginEvent> record(LoginEvent event) {
        return ResponseEntity.ok(loginService.recordLogin(event));
    }

    public ResponseEntity<List<LoginEvent>> eventsByUser(Long userId) {
        return ResponseEntity.ok(loginService.getEventsByUser(userId));
    }
}
