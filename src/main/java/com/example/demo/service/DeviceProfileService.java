package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;

import java.util.List;

public class DeviceProfileService {

    private final DeviceProfileRepository deviceRepo;

    public DeviceProfileService(DeviceProfileRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    public DeviceProfile registerDevice(DeviceProfile device) {
        return deviceRepo.save(device);
    }

    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = deviceRepo.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
        device.setIsTrusted(trust);
        return deviceRepo.save(device);
    }

    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return deviceRepo.findAll().stream().filter(d -> d.getUserId().equals(userId)).toList();
    }

    public DeviceProfile findByDeviceId(String deviceId) {
        return deviceRepo.findByDeviceId(deviceId).orElseThrow(() -> new RuntimeException("Device not found"));
    }
}
