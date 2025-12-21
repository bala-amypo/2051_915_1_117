package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.function.Function;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;
    private final boolean isTestMode;

    public JwtUtil(String secret, long validityInMs, boolean isTestMode) {
        this.secret = secret;
        this.validityInMs = validityInMs;
        this.isTestMode = isTestMode;
    }

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRole(String token) {
        return (String) extractAllClaims(token).get("role");
    }

    private <T> T extractClaim(String token, Function<Claims, T> resolver) {
        return resolver.apply(extractAllClaims(token));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
