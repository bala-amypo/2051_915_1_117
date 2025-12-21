package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/violations")
@Tag(name = "Violation Records", description = "Manage IT policy violation records")
public class ViolationRecordController {

    private final ViolationRecordRepository violationRepo;

    public ViolationRecordController(ViolationRecordRepository violationRepo) {
        this.violationRepo = violationRepo;
    }

    @PostMapping
    public ResponseEntity<ViolationRecord> logViolation(@RequestBody ViolationRecord violation) {
        return ResponseEntity.ok(violationRepo.save(violation));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(violationRepo.findAll().stream()
                .filter(v -> v.getUserId().equals(userId)).toList());
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> markResolved(@PathVariable Long id) {
        ViolationRecord record = violationRepo.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
        record.setResolved(true);
        return ResponseEntity.ok(violationRepo.save(record));
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> getUnresolved() {
        return ResponseEntity.ok(violationRepo.findByResolvedFalse());
    }

    @GetMapping
    public ResponseEntity<List<ViolationRecord>> getAll() {
        return ResponseEntity.ok(violationRepo.findAll());
    }
}
