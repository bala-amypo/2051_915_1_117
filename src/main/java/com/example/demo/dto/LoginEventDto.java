package com.example.demo.dto;

import java.time.LocalDateTime;

public class LoginEventDto {

    private Long id;
    private Long userId;
    private LocalDateTime timestamp;
    private boolean success;
    private String ipAddress;

    public LoginEventDto() {}

    public LoginEventDto(Long id, Long userId, LocalDateTime timestamp, boolean success, String ipAddress) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.success = success;
        this.ipAddress = ipAddress;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
}
