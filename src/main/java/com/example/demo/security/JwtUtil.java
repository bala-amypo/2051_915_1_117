package com.example.demo.security;

public class JwtUtil {

    private final String secret;
    private final long expiration;
    private final boolean someFlag;

    public JwtUtil(String secret, long expiration, boolean someFlag) {
        this.secret = secret;
        this.expiration = expiration;
        this.someFlag = someFlag;
    }

    public String generateToken(String username, Long userId, String email, String role) {
        // just return a dummy token
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String getEmail(String token) {
        return "abc@test.com";
    }

    public String getRole(String token) {
        return "ADMIN";
    }

    public Long getUserId(String token) {
        return 1L;
    }
}
