package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.Optional;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile d);

    Optional<DeviceProfile> findByDeviceId(String id);

    // IMPORTANT: Boolean (wrapper), not boolean
    DeviceProfile updateTrustStatus(Long id, Boolean trust);
}
