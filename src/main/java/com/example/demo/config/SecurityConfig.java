package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtUtil jwtUtil() {
        String secret = "mySecretKey";        // replace with property if needed
        long validityInMs = 3600000;          // 1 hour
        boolean isTestMode = false;           // change as needed
        return new JwtUtil(secret, validityInMs, isTestMode);
    }

    // Other beans (PasswordEncoder, SecurityFilterChain, etc.) go here
}
