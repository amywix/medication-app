package com.example.MediTime.model;

import jakarta.persistence.*;

@Entity
public class MedicationInteraction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interactionId;

    private String medicationId_1;
    private String medicationId_2;
    private String interactionDescription;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    // Getters and setters

    public Long getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Long interactionId) {
        this.interactionId = interactionId;
    }

    public String getMedicationId_1() {
        return medicationId_1;
    }

    public void setMedicationId_1(String medicationId_1) {
        this.medicationId_1 = medicationId_1;
    }

    public String getMedicationId_2() {
        return medicationId_2;
    }

    public void setMedicationId_2(String medicationId_2) {
        this.medicationId_2 = medicationId_2;
    }

    public String getInteractionDescription() {
        return interactionDescription;
    }

    public void setInteractionDescription(String interactionDescription) {
        this.interactionDescription = interactionDescription;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }
}
