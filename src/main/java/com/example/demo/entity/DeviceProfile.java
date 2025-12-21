package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_profiles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userId", "deviceId"})
})
public class DeviceProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String deviceId;
    private String deviceType;
    private String osVersion;
    private LocalDateTime lastSeen = LocalDateTime.now();
    private Boolean isTrusted = false;

    // Getters and Setters
}
