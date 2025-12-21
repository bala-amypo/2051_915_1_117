package com.example.demo.controller;

import com.example.demo.dto.ViolationRecordDTO;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ViolationRecordDTO create(@RequestBody ViolationRecordDTO dto) {
        return service.createViolation(dto);
    }

    @GetMapping("/{id}")
    public ViolationRecordDTO getById(@PathVariable Long id) {
        return service.getViolationById(id);
    }

    @GetMapping
    public List<ViolationRecordDTO> getAll() {
        return service.getAllViolations();
    }

    @PutMapping("/{id}")
    public ViolationRecordDTO update(@PathVariable Long id,
                                     @RequestBody ViolationRecordDTO dto) {
        return service.updateViolation(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteViolation(id);
    }
}
