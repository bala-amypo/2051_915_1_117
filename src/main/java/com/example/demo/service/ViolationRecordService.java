package com.example.demo.service;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ViolationRecordService {
    private final ViolationRecordRepository violationRecordRepository;
    public ViolationRecordService(ViolationRecordRepository violationRecordRepository) {
        this.violationRecordRepository = violationRecordRepository;
    }
    public ViolationRecord logViolation(ViolationRecord violation) {
        return violationRecordRepository.save(violation);
    }
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return violationRecordRepository.findAll();
    }
    public void markResolved(Long id) {
        ViolationRecord violation = violationRecordRepository.findById(id).orElseThrow();
        violation.setResolved(true);
        violationRecordRepository.save(violation);
    }
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRecordRepository.findByResolvedFalse();
    }
    public List<ViolationRecord> getAllViolations() {
        return violationRecordRepository.findAll();
    }
}
