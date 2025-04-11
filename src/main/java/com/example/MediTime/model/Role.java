//Amy Wickham 12178502
package com.example.MediTime.model;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    // Getters and Setters
}