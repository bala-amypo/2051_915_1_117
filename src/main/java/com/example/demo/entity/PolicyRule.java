package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table(name = "policy_rules") @Getter @Setter
public class PolicyRule {
    @Id @GeneratedValue private Long id;
    @Column(name = "rule_code") private String ruleCode;
    private String description, severity;
    @Column(name = "conditions_json") private String conditionsJson;
    private Boolean active = true;
}
