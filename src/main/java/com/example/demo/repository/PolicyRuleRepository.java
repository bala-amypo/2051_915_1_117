public interface PolicyRuleRepository {
    PolicyRule save(PolicyRule r);
    List<PolicyRule> findAll();
    List<PolicyRule> findByActiveTrue();
}
