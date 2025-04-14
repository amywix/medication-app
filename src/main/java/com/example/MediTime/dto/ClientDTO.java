// Amy Wickham 12178502
// Amy Wickham 12178502
// File: ClientDTO.java
// Description: See MediTime documentation. This file is part of the medication management system.

package com.example.meditime.dto;

public class ClientDTO {
    private String name;
    private String dob;
    private String contact;

    public ClientDTO() {}

    public ClientDTO(String name, String dob, String contact) {
        this.name = name;
        this.dob = dob;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}