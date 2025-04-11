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

    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getInteractionInfo() {
        return interactionInfo;
    }

    public void setInteractionInfo(String interactionInfo) {
        this.interactionInfo = interactionInfo;
    }
    
}