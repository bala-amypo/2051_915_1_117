package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "policy_rules", uniqueConstraints = {
    @UniqueConstraint(columnNames = "rule_code")
})
public class PolicyRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "rule_code", nullable = false)
    private String ruleCode;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotNull
    @Column(nullable = false)
    private String severity; // LOW, MEDIUM, HIGH, CRITICAL

    @Column(name = "conditions_json")
    private String conditionsJson;

    @Column
    private Boolean active = true;

    // Constructors
    public PolicyRule() {}

    public PolicyRule(String ruleCode, String description, String severity, String conditionsJson) {
        this.ruleCode = ruleCode;
        this.description = description;
        this.severity = severity;
        this.conditionsJson = conditionsJson;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getConditionsJson() { return conditionsJson; }
    public void setConditionsJson(String conditionsJson) { this.conditionsJson = conditionsJson; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
