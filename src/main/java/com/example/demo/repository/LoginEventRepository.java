package com.example.demo.repository;

import com.example.demo.entity.LoginEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {
    @Query("SELECT e FROM LoginEvent e WHERE e.userId = :userId AND e.loginStatus = :status")
    List<LoginEvent> findByUserIdAndLoginStatus(@Param("userId") Long userId, @Param("status") String status);
}
