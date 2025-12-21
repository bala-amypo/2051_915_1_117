package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "policy_rules", uniqueConstraints = {
    @UniqueConstraint(columnNames = "rule_code")
})
@Data
public class PolicyRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "rule_code")
    private String ruleCode;
    
    private String description;
    private String severity; // LOW, MEDIUM, HIGH, CRITICAL
    @Column(name = "conditions_json")
    private String conditionsJson;
    private Boolean active = true;
}
