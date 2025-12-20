package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ViolationRecord> log(@RequestBody ViolationRecord record) {
        return ResponseEntity.ok(service.logViolation(record));
    }

    @GetMapping("/unresolved")
    public ResponseEntity<?> unresolved() {
        return ResponseEntity.ok(service.getUnresolvedViolations());
    }
}
