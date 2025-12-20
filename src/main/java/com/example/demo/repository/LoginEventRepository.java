public interface LoginEventRepository {
    LoginEvent save(LoginEvent e);
    List<LoginEvent> findByUserId(Long userId);
    List<LoginEvent> findByUserIdAndLoginStatus(Long userId, String status);
}
