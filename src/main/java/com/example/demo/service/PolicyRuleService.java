package com.example.demo.service;
import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PolicyRuleService {
    private final PolicyRuleRepository policyRuleRepository;
    public PolicyRuleService(PolicyRuleRepository policyRuleRepository) {
        this.policyRuleRepository = policyRuleRepository;
    }
    public PolicyRule createRule(PolicyRule rule) { return policyRuleRepository.save(rule); }
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = policyRuleRepository.findById(id).orElseThrow();
        existing.setRuleCode(rule.getRuleCode());
        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setConditionsJson(rule.getConditionsJson());
        existing.setActive(rule.getActive());
        return policyRuleRepository.save(existing);
    }
    public List<PolicyRule> getActiveRules() { return policyRuleRepository.findByActiveTrue(); }
    public Optional<PolicyRule> getRuleByCode(String ruleCode) {
        return policyRuleRepository.findAll().stream()
            .filter(r -> ruleCode.equals(r.getRuleCode())).findFirst();
    }
    public List<PolicyRule> getAllRules() { return policyRuleRepository.findAll(); }
}
