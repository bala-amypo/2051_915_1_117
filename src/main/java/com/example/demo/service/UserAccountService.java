package com.example.demo.service;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UserAccountService {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    public UserAccountService(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public UserAccount createUser(UserAccount user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userAccountRepository.save(user);
    }
    public Optional<UserAccount> getUserById(Long id) {
        return userAccountRepository.findById(id);
    }
    public void updateUserStatus(Long id, String status) {
        UserAccount user = userAccountRepository.findById(id).orElseThrow();
        user.setStatus(status);
        userAccountRepository.save(user);
    }
    public List<UserAccount> getAllUsers() { return userAccountRepository.findAll(); }
    public Optional<UserAccount> findByUsername(String username) {
        return userAccountRepository.findByUsername(username);
    }
}
