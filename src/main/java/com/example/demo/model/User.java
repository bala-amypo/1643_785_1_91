package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role;

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        if (ticket.getUser() != this) {
            ticket.setUser(this); 
        }
    }
}