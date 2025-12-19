package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import java.util.List;

public interface ViolationRecordService {

    ViolationRecord logViolation(ViolationRecord record);

    List<ViolationRecord> getUnresolvedViolations();

    ViolationRecord markResolved(Long id);
}
