public interface ViolationRecordRepository {
    ViolationRecord save(ViolationRecord v);
    Optional<ViolationRecord> findById(Long id);
    List<ViolationRecord> findByResolvedFalse();
}
