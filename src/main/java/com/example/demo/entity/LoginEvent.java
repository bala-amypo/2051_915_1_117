package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "login_events")
@Data
public class LoginEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "ip_address", nullable = false)
    private String ipAddress;
    
    private String location;
    
    @Column(name = "device_id", nullable = false)
    private String deviceId;
    
    private LocalDateTime timestamp = LocalDateTime.now();
    
    @Column(name = "login_status")
    private String loginStatus; // SUCCESS, FAILED
}
