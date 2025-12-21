package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "violation_records")
public class ViolationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotNull
    @Column(name = "policy_rule_id", nullable = false)
    private Long policyRuleId;

    @NotNull
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "violation_type")
    private String violationType;

    @Column
    private String details;

    @Column(nullable = false)
    private String severity;

    @CreationTimestamp
    @Column(name = "detected_at", nullable = false)
    private LocalDateTime detectedAt;

    @Column
    private Boolean resolved = false;

    // Constructors
    public ViolationRecord() {}

    public ViolationRecord(Long userId, Long policyRuleId, Long eventId, String violationType, 
                          String details, String severity) {
        this.userId = userId;
        this.policyRuleId = policyRuleId;
        this.eventId = eventId;
        this.violationType = violationType;
        this.details = details;
        this.severity = severity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getPolicyRuleId() { return policyRuleId; }
    public void setPolicyRuleId(Long policyRuleId) { this.policyRuleId = policyRuleId; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public String getViolationType() { return violationType; }
    public void setViolationType(String violationType) { this.violationType = violationType; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}
