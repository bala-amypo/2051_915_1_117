package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "Authentication", description = "User registration and login")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserAccountService userAccountService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userAccountService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        UserAccount savedUser = userAccountService.createUser(user);
        return ResponseEntity.ok(Map.of("message", "User registered", "userId", savedUser.getId()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        // Simplified login - in production, validate credentials
        String token = jwtUtil.generateToken(credentials.get("username"), "USER");
        return ResponseEntity.ok(Map.of("token", token, "role", "USER"));
    }
}
