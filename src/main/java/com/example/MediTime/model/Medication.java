//Amy Wickham 12178502
package com.example.MediTime.model;

import jakarta.persistence.*;

@Entity
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicationId;

    private String name;
    private String description;
    private String sideEffects;
    private String interactionInfo;

    // Getters and Setters
}