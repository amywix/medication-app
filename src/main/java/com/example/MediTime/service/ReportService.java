package com.example.MediTime.service;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

    public String generateReportForManager(Long managerId) {
        // Placeholder report logic
        return "📊 Report generated for manager ID: " + managerId;
    }
}