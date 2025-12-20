package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    public ResponseEntity<UserAccount> create(UserAccount user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    public ResponseEntity<UserAccount> get(Long id) {
        UserAccount u = userService.getUserById(id);
        return u != null ? ResponseEntity.ok(u) : ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<UserAccount>> all() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
