package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_profiles")
@Data
public class DeviceProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "device_id")
    private String deviceId;
    
    @Column(name = "device_type")
    private String deviceType;
    
    @Column(name = "os_version")
    private String osVersion;
    
    @Column(name = "last_seen")
    private LocalDateTime lastSeen = LocalDateTime.now();
    
    @Column(name = "is_trusted")
    private Boolean isTrusted = false;
}
