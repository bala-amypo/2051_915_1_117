public interface DeviceProfileRepository {
    DeviceProfile save(DeviceProfile d);
    Optional<DeviceProfile> findById(Long id);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
