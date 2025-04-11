//Amy Wickham 12178502
package com.example.MediTime.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MedicationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    private ClientMedication clientMedication;

    @ManyToOne
    private User user;

    private LocalDateTime scheduledTime;
    private LocalDateTime actualTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String notes;

    public enum Status {
        Given, Skipped, Missed, Late
    }

    // Getters and Setters
}