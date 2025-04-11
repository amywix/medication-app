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
    //@JoinColumn(name = "carer_id")  // optional: maps to DB column name
    private User carer;  // this is the "carerId" from the diagram

    private LocalDateTime scheduledTime;
    private LocalDateTime actualTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String notes;

    public enum Status {
        Given, Skipped, Missed, Late
    }

    // Getters and Setters

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public ClientMedication getClientMedication() {
        return clientMedication;
    }

    public void setClientMedication(ClientMedication clientMedication) {
        this.clientMedication = clientMedication;
    }

    public User getCarer() {
        return carer;
    }

    public void setCarer(User carer) {
        this.carer = carer;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public LocalDateTime getActualTime() {
        return actualTime;
    }

    public void setActualTime(LocalDateTime actualTime) {
        this.actualTime = actualTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
