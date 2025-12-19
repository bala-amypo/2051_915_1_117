package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    // Used in testDeviceControllerLookup()
    public ResponseEntity<DeviceProfile> lookup(String deviceId) {
        Optional<DeviceProfile> device = deviceService.findByDeviceId(deviceId);
        return device.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Optional
    public ResponseEntity<DeviceProfile> register(DeviceProfile device) {
        return ResponseEntity.ok(deviceService.registerDevice(device));
    }
}
