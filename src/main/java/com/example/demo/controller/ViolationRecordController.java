package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ViolationRecordController {
    @Autowired
    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    public ResponseEntity<ViolationRecord> log(ViolationRecord record) {
        return ResponseEntity.ok(violationService.logViolation(record));
    }
}
