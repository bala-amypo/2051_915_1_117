package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "login_events")
public class LoginEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String ipAddress;
    private String location;
    private String deviceId;
    private LocalDateTime timestamp = LocalDateTime.now();
    private String loginStatus; // SUCCESS / FAILED

    // Getters and Setters
}
