package com.example.MediTime.service;

import com.example.MediTime.model.Report;
import com.example.MediTime.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    public Report save(Report report) {
        return reportRepository.save(report);
    }

    public Report findById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        reportRepository.deleteById(id);
    }
}