package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    // ✅ Changed: long secret for HS512 (≥ 512 bits)
    private String secret = "Y29tLmV4YW1wbGUuZGVtb19zZWNyZXRfa2V5X2Zvcl9IVzUxMiBtdXN0X2JlX2xvbmdfZW5vdWdoX2Zvcl9zZWN1cml0eQ==";
    private long expiration = 3600000L; // 1 hour
    private boolean debug = true;

    // No-arg constructor (required by the test)
    public JwtUtil() {
    }

    // Full constructor (used in real config)
    public JwtUtil(String secret, long expiration, boolean debug) {
        this.secret = secret;
        this.expiration = expiration;
        this.debug = debug;
    }

    public String generateToken(String username, Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            if (debug) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public String getUsername(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Long getUserId(String token) {
        return getClaimFromToken(token, claims -> claims.get("userId", Long.class));
    }

    public String getEmail(String token) {
        return getClaimFromToken(token, claims -> claims.get("email", String.class));
    }

    public String getRole(String token) {
        return getClaimFromToken(token, claims -> claims.get("role", String.class));
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
