package com.example.demo.service;
import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceProfileService {
    private final DeviceProfileRepository deviceProfileRepository;
    public DeviceProfileService(DeviceProfileRepository deviceProfileRepository) {
        this.deviceProfileRepository = deviceProfileRepository;
    }
    public DeviceProfile registerDevice(DeviceProfile device) {
        device.setLastSeen(java.time.LocalDateTime.now());
        return deviceProfileRepository.save(device);
    }
    public void updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = deviceProfileRepository.findById(id).orElseThrow();
        device.setIsTrusted(trust);
        device.setLastSeen(java.time.LocalDateTime.now());
        deviceProfileRepository.save(device);
    }
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return deviceProfileRepository.findAll();
    }
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return deviceProfileRepository.findByDeviceId(deviceId);
    }
}
