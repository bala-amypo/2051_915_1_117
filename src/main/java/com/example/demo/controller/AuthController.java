package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "User registration and login")
public class AuthController {

    private final UserAccountService userAccountService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userAccountService,
                          AuthenticationManager authenticationManager,
                          UserDetailsService userDetailsService,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) {
        // Map DTO -> entity
        UserAccount user = new UserAccount();
        user.setEmployeeId(request.getEmployeeId());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // will be encoded in service
        user.setRole(request.getRole());         // ADMIN / USER / AUDITOR

        UserAccount saved = userAccountService.createUser(user);

        // Load UserDetails for token generation
        UserDetails userDetails = userDetailsService.loadUserByUsername(saved.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        JwtResponse response = new JwtResponse(
                token,
                saved.getId(),
                saved.getUsername(),
                saved.getRole()
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    @Operation(summary = "Authenticate and obtain JWT")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        // Authenticate username/password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtil.generateToken(userDetails);

        // Fetch domain user to include id/role in response
        UserAccount user = userAccountService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        JwtResponse response = new JwtResponse(
                token,
                user.getId(),
                user.getUsername(),
                user.getRole()
        );
        return ResponseEntity.ok(response);
    }
}
