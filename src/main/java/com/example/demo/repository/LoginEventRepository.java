package com.example.demo.repository;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventRepository {
    List<LoginEvent> findByUserId(Long userId);
    List<LoginEvent> findFailedLogins(Long userId);
}
