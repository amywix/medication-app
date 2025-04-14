//Amy Wickham 121785021
// Amy Wickham 12178502
// File: ReportDTO.java
// Description: See MediTime documentation. This file is part of the medication management system.

package com.example.meditime.dto;

import lombok.Data;
import com.example.meditime.model.Report;

@Data
public class ReportDTO {
    private Long id;
    private String carerName;
    private String clientName;
    private String notes;
    private String dateCreated;

    public static ReportDTO fromEntity(Report report) {
        if (report == null) return null;
        ReportDTO dto = new ReportDTO();
        dto.setId(report.getReportId());
        dto.setCarerName(report.getCarer().getName());
        dto.setClientName(report.getClient().getName());
        dto.setNotes(report.getNotes());
        dto.setDateCreated(report.getDateCreated().toString());
        return dto;
    }
}