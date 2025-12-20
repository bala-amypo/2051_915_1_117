package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
public class DeviceProfileController {
     @Autowired
    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    public ResponseEntity<DeviceProfile> lookup(String deviceId) {
        Optional<DeviceProfile> d = deviceService.findByDeviceId(deviceId);
        return d.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<DeviceProfile> register(DeviceProfile device) {
        return ResponseEntity.ok(deviceService.registerDevice(device));
    }
}
