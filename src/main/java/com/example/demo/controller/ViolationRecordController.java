package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
@Tag(name = "Violations", description = "Policy violation records and audit")
@SecurityRequirement(name = "JWT")
public class ViolationRecordController {

    private final ViolationRecordService violationRecordService;

    public ViolationRecordController(ViolationRecordService violationRecordService) {
        this.violationRecordService = violationRecordService;
    }

    @PostMapping
    @Operation(summary = "Log a violation record")
    public ResponseEntity<ViolationRecord> logViolation(@RequestBody ViolationRecord violation) {
        return ResponseEntity.ok(violationRecordService.logViolation(violation));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get violations by user")
    public ResponseEntity<List<ViolationRecord>> getViolationsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(violationRecordService.getViolationsByUser(userId));
    }

    @PutMapping("/{id}/resolve")
    @Operation(summary = "Mark violation as resolved")
    public ResponseEntity<Void> markResolved(@PathVariable Long id) {
        violationRecordService.markResolved(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unresolved")
    @Operation(summary = "List unresolved violations")
    public ResponseEntity<List<ViolationRecord>> getUnresolvedViolations() {
        return ResponseEntity.ok(violationRecordService.getUnresolvedViolations());
    }

    @GetMapping
    @Operation(summary = "List all violations")
    public ResponseEntity<List<ViolationRecord>> getAllViolations() {
        return ResponseEntity.ok(violationRecordService.getAllViolations());
    }
}
