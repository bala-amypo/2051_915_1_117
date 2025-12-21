package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;
    private String role;
    private String status;

    // ===== getters & setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {          // ✅ REQUIRED
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {               // ✅ REQUIRED
        return role;
    }

    public void setRole(String role) {      // ✅ REQUIRED
        this.role = role;
    }

    public String getStatus() {             // ✅ REQUIRED
        return status;
    }

    public void setStatus(String status) {  // ✅ REQUIRED
        this.status = status;
    }
}
