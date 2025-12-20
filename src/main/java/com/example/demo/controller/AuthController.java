package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import org.springframework.http.ResponseEntity;

public class AuthController {

    public ResponseEntity<String> login(UserAccount user) {
        return ResponseEntity.ok("dummy-token"); // placeholder
    }
}
