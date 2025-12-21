package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts", uniqueConstraints = {
    @UniqueConstraint(columnNames = "employee_id"), 
    @UniqueConstraint(columnNames = "username"), 
    @UniqueConstraint(columnNames = "email")
})
@Getter @Setter
public class UserAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name = "employee_id") private String employeeId;
    private String username; 
    private String email; 
    private String password; 
    private String role; 
    private String status = "ACTIVE";
    @Column(name = "created_at") private LocalDateTime createdAt = LocalDateTime.now();
}
