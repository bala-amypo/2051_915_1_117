package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
@Tag(name = "Violation Records", description = "Manage policy violation records")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    @PostMapping
    public ResponseEntity<ViolationRecord> logViolation(@RequestBody ViolationRecord violation) {
        violationService.logViolation(violation);
        return ResponseEntity.ok(violation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(violationService.getViolationsByUser(userId));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<Void> resolveViolation(@PathVariable Long id) {
        violationService.markResolved(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> getUnresolved() {
        return ResponseEntity.ok(violationService.getUnresolvedViolations());
    }

    @GetMapping
    public ResponseEntity<List<ViolationRecord>> getAll() {
        return ResponseEntity.ok(violationService.getAllViolations());
    }
}
