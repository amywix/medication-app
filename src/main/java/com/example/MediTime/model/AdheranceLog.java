//Amy Wickham 12178502
package com.example.MediTime.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AdheranceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adherenceId;

    @ManyToOne
    private ClientMedication clientMedication;

    @ManyToOne
    private User user;

    private LocalDateTime checkedTime;
    private Double adherenceRate;

    // Getters and Setters
}