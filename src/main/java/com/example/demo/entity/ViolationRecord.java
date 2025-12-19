package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class ViolationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long policyRuleId;
    private Long eventId;
    private String violationType;
    private String details;
    private String severity;
    private LocalDateTime detectedAt;
    private boolean resolved;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getPolicyRuleId() {
        return policyRuleId;
    }
    public void setPolicyRuleId(Long policyRuleId) {
        this.policyRuleId = policyRuleId;
    }
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public String getViolationType() {
        return violationType;
    }
    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }
    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }
    public boolean isResolved() {
        return resolved;
    }
    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
    public ViolationRecord(Long id, Long userId, Long policyRuleId, Long eventId, String violationType, String details,
            String severity, LocalDateTime detectedAt, boolean resolved) {
        this.id = id;
        this.userId = userId;
        this.policyRuleId = policyRuleId;
        this.eventId = eventId;
        this.violationType = violationType;
        this.details = details;
        this.severity = severity;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }
    public ViolationRecord() {
    }
    
}
