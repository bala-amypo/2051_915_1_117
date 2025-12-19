package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LoginEvent> record(@RequestBody LoginEvent event) {
        return ResponseEntity.ok(service.recordLogin(event));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getEventsByUser(userId));
    }

    @GetMapping("/user/{userId}/suspicious")
    public ResponseEntity<List<LoginEvent>> suspicious(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getSuspiciousLogins(userId));
    }
}
