package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
@Tag(name = "Login Events", description = "Login event capture and queries")
@SecurityRequirement(name = "JWT")
public class LoginEventController {

    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping("/record")
    @Operation(summary = "Record a login attempt")
    public ResponseEntity<LoginEvent> recordLogin(@RequestBody LoginEvent event) {
        LoginEvent saved = loginEventService.recordLogin(event);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get login events for a user")
    public ResponseEntity<List<LoginEvent>> getEventsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getEventsByUser(userId));
    }

    @GetMapping("/suspicious/{userId}")
    @Operation(summary = "Get suspicious login events for a user")
    public ResponseEntity<List<LoginEvent>> getSuspiciousLogins(@PathVariable Long userId) {
        return ResponseEntity.ok(loginEventService.getSuspiciousLogins(userId));
    }

    @GetMapping
    @Operation(summary = "List all login events")
    public ResponseEntity<List<LoginEvent>> getAllEvents() {
        return ResponseEntity.ok(loginEventService.getAllEvents());
    }
}
