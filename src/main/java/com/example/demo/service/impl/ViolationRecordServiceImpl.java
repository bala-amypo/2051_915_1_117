package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;

import java.util.List;

public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ViolationRecord logViolation(ViolationRecord record) {
        return repository.save(record);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return repository.findByResolvedFalse();
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = repository.findById(id).orElse(null);
        if (record != null) {
            record.setResolved(true);
            return repository.save(record);
        }
        return null;
    }
}
