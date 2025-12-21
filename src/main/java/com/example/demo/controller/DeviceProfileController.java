package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return service.registerDevice(device);
    }

    @GetMapping("/{deviceId}")
    public Optional<DeviceProfile> getByDeviceId(@PathVariable String deviceId) {
        return service.findByDeviceId(deviceId);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile updateTrust(
            @PathVariable Long id,
            @RequestParam boolean trusted) {
        return service.updateTrustStatus(id, trusted);
    }
}
