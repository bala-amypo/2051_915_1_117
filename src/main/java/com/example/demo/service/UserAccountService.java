package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.entity.UserAccount;
import java.util.List;
@Service
public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount getUserById(Long id);

    UserAccount updateUserStatus(Long id, String status);

    List<UserAccount> getAllUsers();
}
