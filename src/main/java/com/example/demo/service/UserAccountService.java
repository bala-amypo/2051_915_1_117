package com.example.demo.service.impl;

import com.example.demo.dto.UserAccountDto;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final List<UserAccountDto> accounts = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public List<UserAccountDto> getAllUserAccounts() {
        return accounts;
    }

    @Override
    public UserAccountDto getUserAccountById(Long id) {
        return accounts.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("UserAccount not found"));
    }

    @Override
    public UserAccountDto createUserAccount(UserAccountDto accountDto) {
        accountDto.setId(idCounter++);
        accounts.add(accountDto);
        return accountDto;
    }

    @Override
    public UserAccountDto updateUserAccount(Long id, UserAccountDto accountDto) {
        UserAccountDto existingAccount = getUserAccountById(id);
        existingAccount.setUsername(accountDto.getUsername());
        existingAccount.setEmail(accountDto.getEmail());
        existingAccount.setPassword(accountDto.getPassword());
        existingAccount.setRole(accountDto.getRole());
        return existingAccount;
    }

    @Override
    public void deleteUserAccount(Long id) {
        UserAccountDto account = getUserAccountById(id);
        accounts.remove(account);
    }
}
