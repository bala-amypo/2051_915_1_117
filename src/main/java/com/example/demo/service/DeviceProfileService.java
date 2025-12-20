package com.example.demo.service;

import java.util.Optional;
import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);

    Optional<DeviceProfile> findByDeviceId(String deviceId);

    DeviceProfile updateTrustStatus(Long id, boolean trusted);
}
