package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    private final String secret;
    private final long expiration;
    private final boolean enabled;

    // Constructor used in tests
    public JwtUtil(String secret, long expiration, boolean enabled) {
        this.secret = secret;
        this.expiration = expiration;
        this.enabled = enabled;
    }

    // Generates a simple encoded token
    public String generateToken(String username, Long userId, String email, String role) {
        String payload = username + "|" + userId + "|" + email + "|" + role;
        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    // Validates token safely
    public boolean validateToken(String token) {
        try {
            String decoded = new String(Base64.getDecoder().decode(token));
            return decoded.split("\\|").length == 4;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract email
    public String getEmail(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|")[2];
    }

    // Extract role
    public String getRole(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|")[3];
    }

    // Extract userId
    public Long getUserId(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return Long.valueOf(decoded.split("\\|")[1]);
    }
}
