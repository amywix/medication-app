//Amy Wickham 12178502
package com.example.meditime.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    private String name;
    private LocalDate dob;
    private String contactInfo;

    @ManyToOne
    private User carer;

     public Client() {}
     
    public Client(String name, LocalDate dob, String contactInfo) {
    this.name = name;
    this.dob = dob;
    this.contactInfo = contactInfo;
}

    // Getters and Setters

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public User getCarer() {
        return carer;
    }

    public void setCarer(User manager) {
        this.carer = manager;
    }
    
}