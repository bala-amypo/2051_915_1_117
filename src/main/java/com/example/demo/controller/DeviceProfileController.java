package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;

public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    public ResponseEntity<DeviceProfile> register(DeviceProfile device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    public ResponseEntity<DeviceProfile> lookup(String deviceId) {
        Optional<DeviceProfile> device = service.findByDeviceId(deviceId);
        return ResponseEntity.ok(device.orElse(null));
    }
}
