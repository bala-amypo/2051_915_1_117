package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;

public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    public ResponseEntity<ViolationRecord> log(ViolationRecord record) {
        return ResponseEntity.ok(service.logViolation(record));
    }

    public ResponseEntity<List<ViolationRecord>> unresolved() {
        return ResponseEntity.ok(service.getUnresolvedViolations());
    }
}
