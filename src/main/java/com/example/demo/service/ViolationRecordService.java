package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ViolationRecord;

public interface ViolationRecordService {

    ViolationRecord logViolation(ViolationRecord record);

    List<ViolationRecord> getUnresolvedViolations();

    ViolationRecord markResolved(Long id);
}
