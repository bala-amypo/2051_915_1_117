package com.example.demo.controller;

import com.example.demo.dto.UserAccountDto;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/useraccounts")
@Validated
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    // GET all user accounts
    @GetMapping
    public ResponseEntity<List<UserAccountDto>> getAllUserAccounts() {
        List<UserAccountDto> accounts = userAccountService.getAllUserAccounts();
        return ResponseEntity.ok(accounts);
    }

    // GET user account by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserAccountDto> getUserAccountById(@PathVariable Long id) {
        UserAccountDto account = userAccountService.getUserAccountById(id);
        return ResponseEntity.ok(account);
    }

    // POST create a new user account
    @PostMapping
    public ResponseEntity<UserAccountDto> createUserAccount(@Valid @RequestBody UserAccountDto accountDto) {
        UserAccountDto createdAccount = userAccountService.createUserAccount(accountDto);
        return ResponseEntity.ok(createdAccount);
    }

    // PUT update user account by ID
    @PutMapping("/{id}")
    public ResponseEntity<UserAccountDto> updateUserAccount(@PathVariable Long id,
                                                            @Valid @RequestBody UserAccountDto accountDto) {
        UserAccountDto updatedAccount = userAccountService.updateUserAccount(id, accountDto);
        return ResponseEntity.ok(updatedAccount);
    }

    // DELETE user account by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserAccount(@PathVariable Long id) {
        userAccountService.deleteUserAccount(id);
        return ResponseEntity.noContent().build();
    }
}
