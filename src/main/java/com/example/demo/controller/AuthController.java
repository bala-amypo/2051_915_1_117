package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import org.springframework.http.ResponseEntity;

public class AuthController {

    public AuthController() {
        // No JwtUtil needed
    }

    // Dummy login method
    public ResponseEntity<String> login(UserAccount user) {
        // Just return a dummy token string
        return ResponseEntity.ok("dummy-token");
    }

    // Dummy logout method
    public ResponseEntity<String> logout(UserAccount user) {
        return ResponseEntity.ok("logged out");
    }
}
