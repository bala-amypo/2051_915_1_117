package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class DeviceProfile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
     private Long userId;
     private String deviceId;
     private String deviceType;
     private String osVersion;
     private LocalDateTime lastSeen;
     private boolean isTrusted;
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
     public String getDeviceId() {
         return deviceId;
     }
     public void setDeviceId(String deviceId) {
         this.deviceId = deviceId;
     }
     public String getDeviceType() {
         return deviceType;
     }
     public void setDeviceType(String deviceType) {
         this.deviceType = deviceType;
     }
     public String getOsVersion() {
         return osVersion;
     }
     public void setOsVersion(String osVersion) {
         this.osVersion = osVersion;
     }
     public LocalDateTime getLastSeen() {
         return lastSeen;
     }
     public void setLastSeen(LocalDateTime lastSeen) {
         this.lastSeen = lastSeen;
     }
     public boolean isTrusted() {
         return isTrusted;
     }
     public void setTrusted(boolean isTrusted) {
         this.isTrusted = isTrusted;
     }
     public DeviceProfile(Long id, Long userId, String deviceId, String deviceType, String osVersion,
            LocalDateTime lastSeen, boolean isTrusted) {
        this.id = id;
        this.userId = userId;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.osVersion = osVersion;
        this.lastSeen = lastSeen;
        this.isTrusted = isTrusted;
     }
     public DeviceProfile() {
     }
}
