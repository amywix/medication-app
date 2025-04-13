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