package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository repo,
                                  PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount u = repo.findById(id).orElse(null);
        if (u != null) {
            u.setStatus(status);
            return repo.save(u);
        }
        return null;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }
}
