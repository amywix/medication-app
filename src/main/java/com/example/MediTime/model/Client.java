//Amy Wickham 12178502
package com.example.MediTime.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String name;
    private LocalDate dob;
    private String contactInfo;

    @ManyToOne
    private User manager;

    // Getters and Setters
}