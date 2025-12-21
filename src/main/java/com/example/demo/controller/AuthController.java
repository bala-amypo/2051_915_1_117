package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;

    public AuthController(
            UserAccountService userAccountService,
            JwtUtil jwtUtil
    ) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userAccountService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount user) {
        UserAccount dbUser = userAccountService.findByUsername(user.getUsername());
        if (dbUser != null) {
            return jwtUtil.generateToken(dbUser.getUsername(), dbUser.getRole());
        }
        return "INVALID_CREDENTIALS";
    }
}
