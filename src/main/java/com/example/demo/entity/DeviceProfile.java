package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_profiles")
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String deviceId;
    private boolean trusted;

    private LocalDateTime lastSeen;

    public DeviceProfile() {
        this.lastSeen = LocalDateTime.now();
        this.trusted = false;
    }

    // ===== getters =====
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    // ===== setters =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }

    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }
}
