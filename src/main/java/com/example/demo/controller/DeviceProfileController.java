package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Devices", description = "Device profile management")
@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {
    private final DeviceProfileService deviceProfileService;

    public DeviceProfileController(DeviceProfileService deviceProfileService) {
        this.deviceProfileService = deviceProfileService;
    }

    @PostMapping
    public DeviceProfile registerDevice(@RequestBody DeviceProfile device) {
        return deviceProfileService.registerDevice(device);
    }

    @PutMapping("/{id}/trust")
    public ResponseEntity<?> updateTrustStatus(@PathVariable Long id, @RequestBody Boolean trust) {
        deviceProfileService.updateTrustStatus(id, trust);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getDevicesByUser(@PathVariable Long userId) {
        return deviceProfileService.getDevicesByUser(userId);
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> findByDeviceId(@PathVariable String deviceId) {
        return deviceProfileService.findByDeviceId(deviceId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
