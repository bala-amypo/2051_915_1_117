package com.example.demo.repository;

import com.example.demo.entity.ViolationRecord;
import java.util.List;
import java.util.Optional;

public interface ViolationRecordRepository {
    Optional<ViolationRecord> findById(Long id);
    List<ViolationRecord> findAll();
}
