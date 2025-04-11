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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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