package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity;
@Table(name = "users")
public class User{
    
    @Id
    @GeneratedValue()
}