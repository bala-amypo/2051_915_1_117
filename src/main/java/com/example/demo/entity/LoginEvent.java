package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity @Table(name = "login_events") @Getter @Setter
public class LoginEvent {
    @Id @GeneratedValue private Long id;
    @Column(name
