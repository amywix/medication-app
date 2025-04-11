//Amy Wickham 12178502
package com.example.MediTime.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String password;

    @ManyToOne
    private Role role;

    // Getters and Setters
    
}