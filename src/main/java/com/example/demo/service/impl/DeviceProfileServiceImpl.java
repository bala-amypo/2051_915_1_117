package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public DeviceProfile updateTrustStatus(Long id, boolean trusted) {
        DeviceProfile device = deviceRepo.findById(id).orElseThrow();
        device.setIsTrusted(trusted);
        device.setLastSeen(LocalDateTime.now());
        return deviceRepo.save(device);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return deviceRepo.findByDeviceId(deviceId);
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return deviceRepo.findAll();
    }
}
