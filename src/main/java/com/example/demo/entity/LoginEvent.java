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

    private String loginStatus; // SUCCESS / FAILED
    private String ipAddress;
    private String deviceId;

    private LocalDateTime timestamp;

    public LoginEvent() {
        this.timestamp = LocalDateTime.now();
    }

    // ===== getters =====
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // ===== setters =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
