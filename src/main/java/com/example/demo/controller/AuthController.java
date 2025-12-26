package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    // very simple login that just echoes a token using provided params
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String email,
            @RequestParam String role,
            @RequestParam Long userId) {

        String token = jwtUtil.generateToken(email, role, userId);
        return ResponseEntity.ok(token);
    }
}
