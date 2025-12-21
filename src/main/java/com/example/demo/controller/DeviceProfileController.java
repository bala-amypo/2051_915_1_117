package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device Profiles", description = "Manage user devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        deviceService.registerDevice(device);
        return ResponseEntity.ok(device);
    }

    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrust(@PathVariable Long id, @RequestBody Boolean trust) {
        deviceService.updateTrustStatus(id, trust);
        return ResponseEntity.ok(deviceService.getDevicesByUser(id).stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getDevicesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(deviceService.getDevicesByUser(userId));
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> findByDeviceId(@PathVariable String deviceId) {
        return ResponseEntity.ok(deviceService.findByDeviceId(deviceId));
    }
}
