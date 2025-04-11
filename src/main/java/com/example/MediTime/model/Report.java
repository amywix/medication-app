package com.example.MediTime.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    private User caregiver;  // caregiver writing the report

    @ManyToOne
    private User patient;  // patient the report is about

    private String notes;

    private LocalDateTime dateCreated;

    // Constructors
    public Report() {
        this.dateCreated = LocalDateTime.now();
    }

    public Long getReportId() {
        return reportId;
    }

    // Getters and setters...
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

   

    public User getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(User caregiver) {
        this.caregiver = caregiver;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
