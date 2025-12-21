package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;

import java.util.List;

public class ViolationRecordService {

    private final ViolationRecordRepository violationRepo;

    public ViolationRecordService(ViolationRecordRepository violationRepo) {
        this.violationRepo = violationRepo;
    }

    public ViolationRecord logViolation(ViolationRecord violation) {
        return violationRepo.save(violation);
    }

    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return violationRepo.findAll().stream()
                .filter(v -> v.getUserId().equals(userId)).toList();
    }

    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = violationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Violation not found"));
        record.setResolved(true);
        return violationRepo.save(record);
    }

    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }

    public List<ViolationRecord> getAllViolations() {
        return violationRepo.findAll();
    }
}
