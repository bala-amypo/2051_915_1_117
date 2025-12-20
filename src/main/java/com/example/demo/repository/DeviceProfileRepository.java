package com.example.demo.repository;

import com.example.demo.entity.DeviceProfile;
import java.util.Optional;

public interface DeviceProfileRepository {
    Optional<DeviceProfile> findByDeviceId(String deviceId);
    Optional<DeviceProfile> findByUserId(Long userId);
}
