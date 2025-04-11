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

    public Long getClientMedicationId() {
        return clientMedicationId;
    }

    public void setClientMedicationId(Long clientMedicationId) {
        this.clientMedicationId = clientMedicationId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
}