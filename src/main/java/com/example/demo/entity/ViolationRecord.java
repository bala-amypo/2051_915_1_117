package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "violation_records")
@Data
public class ViolationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "policy_rule_id")
    private Long policyRuleId;
    
    @Column(name = "event_id")
    private Long eventId;
    
    @Column(name = "violation_type")
    private String violationType;
    private String details;
    private String severity;
    
    @Column(name = "detected_at")
    private LocalDateTime detectedAt = LocalDateTime.now();
    
    private Boolean resolved = false;
}
