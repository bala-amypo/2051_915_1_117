package com.example.demo.service.impl;

import com.example.demo.dto.DeviceProfileDTO;
import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceProfile createDevice(DeviceProfileDTO dto) {
        DeviceProfile device = new DeviceProfile();
        device.setUserId(dto.getUserId());
        device.setDeviceId(dto.getDeviceId());
        device.setDeviceType(dto.getDeviceType());
        device.setOsVersion(dto.getOsVersion());
        device.setIsTrusted(dto.getIsTrusted()); // ✅ FIXED
        device.setLastSeen(dto.getLastSeen());
        return repository.save(device);
    }

    @Override
    public DeviceProfile getDeviceById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DeviceProfile> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceProfile updateDevice(Long id, DeviceProfileDTO dto) {
        DeviceProfile device = repository.findById(id).orElse(null);
        if (device == null) return null;

        device.setDeviceType(dto.getDeviceType());
        device.setOsVersion(dto.getOsVersion());
        device.setIsTrusted(dto.getIsTrusted()); // ✅ FIXED
        device.setLastSeen(dto.getLastSeen());
        return repository.save(device);
    }

    @Override
    public void deleteDevice(Long id) {
        repository.deleteById(id);
    }
}
