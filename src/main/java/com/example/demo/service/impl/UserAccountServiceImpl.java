package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

import java.util.List;
import java.util.Optional;

public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        // Simply save the user without password encryption
        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        Optional<UserAccount> opt = userRepo.findById(id);
        if (opt.isPresent()) {
            UserAccount user = opt.get();
            user.setStatus(status);
            return userRepo.save(user);
        }
        return null;
    }
}
