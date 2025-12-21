package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
@Getter @Setter
public class UserAccount {
    @Id @GeneratedValue private Long id;
    private String employeeId, username, email, password, role = "USER", status = "ACTIVE";
    @Column(name = "created_at") private LocalDateTime createdAt = LocalDateTime.now();
}
