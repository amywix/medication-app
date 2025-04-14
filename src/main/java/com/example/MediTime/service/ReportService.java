// Amy Wickham 12178502
// File: ReportService.java


package com.example.meditime.service;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

    public String generateReportForManager(Long managerId) {
       
        return "Report generated for manager ID: " + managerId;
    }
}