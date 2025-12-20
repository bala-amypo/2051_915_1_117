package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;

public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    public ResponseEntity<UserAccount> create(UserAccount user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    public ResponseEntity<UserAccount> getById(Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }
}
