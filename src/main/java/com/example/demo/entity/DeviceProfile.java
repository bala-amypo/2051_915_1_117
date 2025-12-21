package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "device_profiles")
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String deviceId;

    private boolean trusted;

    public DeviceProfile() {}

    // getters & setters
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    // REQUIRED by DeviceProfileServiceImpl
    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }
}
