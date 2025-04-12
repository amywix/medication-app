package com.example.MediTime.service;

import com.example.MediTime.model.AdherenceLog;
import com.example.MediTime.repository.AdherenceLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdherenceLogService {

    @Autowired
    private AdherenceLogRepository adherenceLogRepository;

    public List<AdherenceLog> getAllLogs() {
        return adherenceLogRepository.findAll();
    }

    public void saveLog(AdherenceLog log) {
        adherenceLogRepository.save(log);
    }

    public List<AdherenceLog> getLogsByClientMedicationId(Long clientMedicationId) {
        return adherenceLogRepository.findByClientMedicationId(clientMedicationId);
    }

    public void logAdherence(AdherenceLog log) {
        adherenceLogRepository.save(log);
    }
}