package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceRepo;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {

        deviceRepo.findByDeviceId(device.getDeviceId()).ifPresent(existing -> {
            if (existing.getUserId().equals(device.getUserId())) {
                throw new IllegalArgumentException("Device already registered for user");
            }
        });

        return deviceRepo.save(device);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = deviceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));

        device.setIsTrusted(trust);
        return deviceRepo.save(device);
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return deviceRepo.findByUserId(userId);
    }

    @Override
    public java.util.Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return deviceRepo.findByDeviceId(deviceId);
    }
}
