//Amy Wickham 12178502
package com.example.MediTime.model;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderId;

    @ManyToOne
    private ClientMedication clientMedication;

    private LocalTime reminderTime;
    private String reminderType;

    // Getters and Setters
}