package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity;
@Table(name = "users")
public class User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Ling id;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String password;
    private String role = "USER";
    private LocalDateTime createdAt;
    @PrePersist
    void onCreate(){
        createAt = LocalDateTime.now();
    }

    //Getter Method
    public get
}