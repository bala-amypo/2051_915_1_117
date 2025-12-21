package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "policy_rules", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ruleCode"})
})
public class PolicyRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String description;
    private String severity; // LOW / MEDIUM / HIGH / CRITICAL
    private String conditionsJson;
    private Boolean active = true;

    // Getters and Setters
}
