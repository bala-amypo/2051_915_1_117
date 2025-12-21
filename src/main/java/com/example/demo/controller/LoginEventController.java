package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Login Events", description = "Login activity tracking")
@RestController
@RequestMapping("/api/logins")
public class LoginEventController {
    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping("/record")
    public LoginEvent recordLogin(@RequestBody LoginEvent event) {
        return loginEventService.recordLogin(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getEventsByUser(@PathVariable Long userId) {
        return loginEventService.getEventsByUser(userId);
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> getSuspiciousLogins(@PathVariable Long userId) {
        return loginEventService.getSuspiciousLogins(userId);
    }

    @GetMapping
    public List<LoginEvent> getAllEvents() {
        return loginEventService.getAllEvents();
    }
}
