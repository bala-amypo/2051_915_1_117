package com.example.demo.security;

public class JwtUtil {

    public JwtUtil(String key, long time, boolean flag) {
        // dummy constructor
    }

    public String generateToken(String username, Long userId, String email, String role) {
        return username + ":" + userId + ":" + email + ":" + role;
    }

    public boolean validateToken(String token) {
        return token.contains(":"); // dummy validation
    }

    public String getEmail(String token) {
        return token.split(":")[2];
    }

    public String getRole(String token) {
        return token.split(":")[3];
    }

    public Long getUserId(String token) {
        return Long.parseLong(token.split(":")[1]);
    }
}
