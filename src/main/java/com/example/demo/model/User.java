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
    public getId(){
        return id;
    }
    public getFullName(){
        return fullName;
    }
    public getEmail(){
        return email;
    }
    public getPassword(){
        return password;
    }
    public getCreatedAt(){
        return createdAt;
    }

    //Setter Method
    public getId(Long id){
        this.id = id;
    }
    public getFullName(String fullName){
        this.fullName = fullName;
    }
    public getEmail(String email){
        this.email = email;
    }
    public getPassword(String password){
        this.password = password;
    }
    public getCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
}