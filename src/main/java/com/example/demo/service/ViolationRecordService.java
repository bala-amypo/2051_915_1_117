package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;

import java.util.List;

public interface ViolationRecordService {

    ViolationRecord saveViolation(ViolationRecord record);

    List<ViolationRecord> getAllViolations();

    List<ViolationRecord> getViolationsByUser(Long userId);
}
