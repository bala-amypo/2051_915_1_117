package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;

import java.time.LocalDateTime;
import java.util.List;

public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceRepo;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setLastSeen(LocalDateTime.now());
        return deviceRepo.save(device);
    }

    @Override
    public void updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = deviceRepo.findById(id).orElse(null);
        if (device != null) {
            device.setIsTrusted(trust);
            device.setLastSeen(LocalDateTime.now());
            deviceRepo.save(device);
        }
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return deviceRepo.findAll().stream().filter(d -> d.getUserId().equals(userId)).toList();
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return deviceRepo.findByDeviceId(deviceId);
    }
}
