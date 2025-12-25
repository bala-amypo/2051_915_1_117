// src/main/java/com/example/demo/service/impl/ViolationRecordServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {
    private final ViolationRecordRepository violationRepo;

    public ViolationRecordServiceImpl(ViolationRecordRepository violationRepo) {
        this.violationRepo = violationRepo;
    }

    @Override
    public ViolationRecord logViolation(ViolationRecord violation) {
        return violationRepo.save(violation);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        Optional<ViolationRecord> opt = violationRepo.findById(id);
        if (opt.isPresent()) {
            ViolationRecord v = opt.get();
            v.setResolved(true);
            return violationRepo.save(v);
        }
        return null;
    }
}
