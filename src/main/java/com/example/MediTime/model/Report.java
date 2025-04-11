package com.example.MediTime.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    private User carer;  // carer writing the report

    @ManyToOne
    private Client client;  // patient the report is about

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

    public User getCarer() {
        return carer;
    }

    public void setCarer(User carer) {
        this.carer = carer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
