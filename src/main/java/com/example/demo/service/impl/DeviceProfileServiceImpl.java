package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile d) {
        return repo.save(d);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String id) {
        return repo.findByDeviceId(id);
    }

    // EXACT MATCH with interface
    @Override
    public DeviceProfile updateTrustStatus(Long id, Boolean trust) {
        DeviceProfile d = repo.findById(id).orElse(null);
        d.setIsTrusted(trust);
        return repo.save(d);
    }
}
