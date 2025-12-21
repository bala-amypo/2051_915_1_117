package com.example.demo;

import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    // Expose JwtUtil as a Spring bean so it can be injected into JwtAuthenticationFilter
    @Bean
    public JwtUtil jwtUtil(
            @Value("${jwt.secret:mySecretKeyForJWTGenerationAndValidation1234567890}") String secret,
            @Value("${jwt.validity-in-ms:86400000}") long validityInMs
    ) {
        // isTestMode = false for normal runtime
        return new JwtUtil(secret, validityInMs, false);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
