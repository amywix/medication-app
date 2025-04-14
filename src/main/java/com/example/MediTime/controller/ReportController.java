//Amy Wickham 121785021
// Amy Wickham 12178502
// File: ReportController.java
// Description: See MediTime documentation. This file is part of the medication management system.

package com.example.meditime.controller;

import com.example.meditime.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/manager/{managerId}")
    public String generateReport(@PathVariable Long managerId) {
        return reportService.generateReportForManager(managerId);
    }
}