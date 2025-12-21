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

    @Column(unique = true, nullable = false)
    private String deviceId;

    private String deviceType;

    private boolean trusted;

    private LocalDateTime lastSeen;

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    // 🔴 THIS IS THE MISSING METHOD
    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }

    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }
}
