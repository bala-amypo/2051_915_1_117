package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;

import java.util.Optional;

public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return repository.save(device);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return repository.findByDeviceId(deviceId);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, Boolean trusted) {
        DeviceProfile device = repository.findById(id).orElse(null);
        if (device != null) {
            device.setIsTrusted(trusted);
            return repository.save(device);
        }
        return null;
    }
}
