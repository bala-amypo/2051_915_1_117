package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employeeId"}),
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;
    private String username;
    private String email;
    private String password;
    private String role; // ADMIN / USER / AUDITOR
    private String status = "ACTIVE";

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}
