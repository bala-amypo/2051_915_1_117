package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.http.ResponseEntity;

public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    public ResponseEntity<LoginEvent> record(LoginEvent event) {
        return ResponseEntity.ok(service.recordLogin(event));
    }

    public ResponseEntity<List<LoginEvent>> byUser(Long userId) {
        return ResponseEntity.ok(service.getEventsByUser(userId));
    }

    public ResponseEntity<List<LoginEvent>> suspicious(Long userId) {
        return ResponseEntity.ok(service.getSuspiciousLogins(userId));
    }
}
