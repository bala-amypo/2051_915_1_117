package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔥 REQUIRED FOR SPRING BEAN
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repository;

    public ViolationRecordServiceImpl(ViolationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ViolationRecord saveViolation(ViolationRecord record) {
        return repository.save(record);
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return repository.findAll();
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}
