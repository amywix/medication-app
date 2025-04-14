//Amy Wickham 121785021
package com.example.meditime.model;

import jakarta.persistence.*;

@Entity
public class MedicationInteraction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interactionId;

   @ManyToOne
@JoinColumn(name = "medication_id_1")
private Medication medication1;

@ManyToOne
@JoinColumn(name = "medication_id_2")
private Medication medication2;

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

    public Medication getMedication1() {
        return medication1;
    }

    public void setMedication1(Medication medication1) {
        this.medication1 = medication1;
    }

    public Medication getMedication2() {
        return medication2;
    }

    public void setMedication2(Medication medication2) {
        this.medication2 = medication2;
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
