//Amy Wickham 12178502
package com.example.MediTime.model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ClientMedication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientMedicationId;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Medication medication;

    private String dosage;
    private String frequency;
    private LocalDate startDate;
    private LocalDate endDate;

    // Getters and Setters
}