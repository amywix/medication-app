package com.example.MediTime.service;

import com.example.MediTime.model.MedicationLog;
import com.example.MediTime.repository.MedicationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationLogService {

    @Autowired
    private MedicationLogRepository medicationLogRepository;

    public List<MedicationLog> findAll() {
        return medicationLogRepository.findAll();
    }

    public MedicationLog save(MedicationLog log) {
        return medicationLogRepository.save(log);
    }

    public MedicationLog findById(Long id) {
        return medicationLogRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        medicationLogRepository.deleteById(id);
    }
}