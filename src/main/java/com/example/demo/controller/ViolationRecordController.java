package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Violations", description = "Policy violation records")
@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {
    private final ViolationRecordService violationRecordService;

    public ViolationRecordController(ViolationRecordService violationRecordService) {
        this.violationRecordService = violationRecordService;
    }

    @PostMapping
    public ViolationRecord logViolation(@RequestBody ViolationRecord violation) {
        return violationRecordService.logViolation(violation);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getViolationsByUser(@PathVariable Long userId) {
        return violationRecordService.getViolationsByUser(userId);
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<?> markResolved(@PathVariable Long id) {
        violationRecordService.markResolved(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRecordService.getUnresolvedViolations();
    }

    @GetMapping
    public List<ViolationRecord> getAllViolations() {
        return violationRecordService.getAllViolations();
    }
}
