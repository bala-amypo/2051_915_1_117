package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table(name = "policy_rules", uniqueConstraints = {@UniqueConstraint(columnNames = "rule_code")})
@Getter @Setter
public class PolicyRule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name = "rule_code") private String ruleCode;
    private String description; private String severity;
    @Column(name = "conditions_json") private String conditionsJson;
    private Boolean active = true;
}
