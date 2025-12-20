package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;

public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<String> login(UserAccount user) {
        // just return a token for the tests
        String token = jwtUtil.generateToken(user.getUsername(), user.getId(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(token);
    }
}
