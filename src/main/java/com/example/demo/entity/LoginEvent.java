package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
@Entity
public class LoginEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @NotNull(message = "")
    private String ipAddress;
    private String location;
     @NotNull(message = "")
    private String deviceId;
    private LocalDateTime timestamp;
    private String loginStatus;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getLoginStatus() {
        return loginStatus;
    }
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
    public LoginEvent(Long id, Long userId, String ipAddress, String location, String deviceId, LocalDateTime timestamp,
            String loginStatus) {
        this.id = id;
        this.userId = userId;
        this.ipAddress = ipAddress;
        this.location = location;
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.loginStatus = loginStatus;
    }
    public LoginEvent() {
    }
}
