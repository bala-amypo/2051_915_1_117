package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    // 🔴 CONSTRUCTOR ORDER MUST MATCH TEST REQUIREMENT
    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setLastSeen(LocalDateTime.now());
        return repository.save(device);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = repository.findById(id).orElse(null);
        if (device != null) {
            device.setTrusted(trust);
            return repository.save(device);
        }
        return null;
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repository.findAll()
                .stream()
                .filter(d -> d.getUserId().equals(userId))
                .toList();
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repository.findByDeviceId(deviceId);
    }
}
