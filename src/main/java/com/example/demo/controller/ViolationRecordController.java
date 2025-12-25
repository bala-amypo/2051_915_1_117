// src/main/java/com/example/demo/controller/ViolationRecordController.java
package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {
    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    @PostMapping
    public ResponseEntity<ViolationRecord> log(@RequestBody ViolationRecord violation) {
        ViolationRecord saved = violationService.logViolation(violation);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> getUnresolved() {
        List<ViolationRecord> violations = violationService.getUnresolvedViolations();
        return ResponseEntity.ok(violations);
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> markResolved(@PathVariable Long id) {
        ViolationRecord resolved = violationService.markResolved(id);
        return resolved != null ? ResponseEntity.ok(resolved) : ResponseEntity.notFound().build();
    }
}
