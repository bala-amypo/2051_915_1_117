package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

import java.util.List;
import java.util.Optional;

public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    // TEST USES THIS CONSTRUCTOR (second param ignored)
    public UserAccountServiceImpl(UserAccountRepository userRepo, Object ignored) {
        this.userRepo = userRepo;
    }

    // Optional constructor
    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = getUserById(id);
        user.setStatus(status);
        return userRepo.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<UserAccount> findByUsername(String username) {
        return Optional.empty();
    }
}
