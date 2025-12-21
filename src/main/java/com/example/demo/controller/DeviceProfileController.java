package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "Devices", description = "Registered device management")
@SecurityRequirement(name = "JWT")
public class DeviceProfileController {

    private final DeviceProfileService deviceProfileService;

    public DeviceProfileController(DeviceProfileService deviceProfileService) {
        this.deviceProfileService = deviceProfileService;
    }

    @PostMapping
    @Operation(summary = "Register device")
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(deviceProfileService.registerDevice(device));
    }

    @PutMapping("/{id}/trust")
    @Operation(summary = "Update trusted status of a device")
    public ResponseEntity<Void> updateTrustStatus(@PathVariable Long id,
                                                  @RequestParam boolean trust) {
        deviceProfileService.updateTrustStatus(id, trust);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get all devices for a user")
    public ResponseEntity<List<DeviceProfile>> getDevicesByUser(@PathVariable Long userId) {
        // Filter in service or here; here uses service abstraction
        return ResponseEntity.ok(deviceProfileService.getDevicesByUser(userId));
    }

    @GetMapping("/lookup/{deviceId}")
    @Operation(summary = "Find device by deviceId")
    public ResponseEntity<DeviceProfile> findByDeviceId(@PathVariable String deviceId) {
        Optional<DeviceProfile> deviceOpt = deviceProfileService.findByDeviceId(deviceId);
        return deviceOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
