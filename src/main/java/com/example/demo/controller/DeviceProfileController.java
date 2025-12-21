package com.example.demo.controller;

import com.example.demo.dto.DeviceProfileDTO;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceProfileDTO create(@RequestBody DeviceProfileDTO dto) {
        return service.createDevice(dto);
    }

    @GetMapping("/{id}")
    public DeviceProfileDTO getById(@PathVariable Long id) {
        return service.getDeviceById(id);
    }

    @GetMapping
    public List<DeviceProfileDTO> getAll() {
        return service.getAllDevices();
    }

    @PutMapping("/{id}")
    public DeviceProfileDTO update(@PathVariable Long id,
                                   @RequestBody DeviceProfileDTO dto) {
        return service.updateDevice(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteDevice(id);
    }
}
