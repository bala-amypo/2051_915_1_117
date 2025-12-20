package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        if (user.getPassword() != null) {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(status);
            userRepo.save(user);
        }
        return user;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }
}
