package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Device Profiles", description = "Manage user devices")
public class DeviceProfileController {

    private final DeviceProfileRepository deviceRepo;

    public DeviceProfileController(DeviceProfileRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @PostMapping
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(deviceRepo.save(device));
    }

    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrust(@PathVariable Long id, @RequestParam boolean trust) {
        DeviceProfile device = deviceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setIsTrusted(trust);
        return ResponseEntity.ok(deviceRepo.save(device));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getDevicesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(deviceRepo.findAll().stream()
                .filter(d -> d.getUserId().equals(userId)).toList());
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> findByDeviceId(@PathVariable String deviceId) {
        return ResponseEntity.ok(deviceRepo.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found")));
    }
}
