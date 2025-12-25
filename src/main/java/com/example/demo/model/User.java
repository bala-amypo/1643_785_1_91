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
    private String email;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private java.util.List<Ticket> tickets = new java.util.ArrayList<>();

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        if (ticket.getUser() != this) {
            ticket.setUser(this);
        }
    }
}