package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "policy_rules")
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ruleCode;

    private String description;
    private String severity; // LOW / MEDIUM / HIGH / CRITICAL
    private String conditionsJson;
    private Boolean active = true;

    // Getters
    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public String getDescription() { return description; }
    public String getSeverity() { return severity; }
    public String getConditionsJson() { return conditionsJson; }
    public Boolean getActive() { return active; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    public void setDescription(String description) { this.description = description; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setConditionsJson(String conditionsJson) { this.conditionsJson = conditionsJson; }
    public void setActive(Boolean active) { this.active = active; }
}
