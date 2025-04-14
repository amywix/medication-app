//Amy Wickham 121785021
package com.example.meditime.service;

import com.example.meditime.model.ClientMedication;
import com.example.meditime.model.MedicationLog;
import com.example.meditime.repository.ClientMedicationRepository;
import com.example.meditime.repository.MedicationLogRepository;
import com.example.meditime.repository.UserRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationLogService {

    @Autowired
    private MedicationLogRepository medicationLogRepository;
     @Autowired
    private ClientMedicationRepository clientMedicationRepository;
      @Autowired
    private UserRepository userRepository;

    public List<MedicationLog> findAll() {
        return medicationLogRepository.findAll();
    }

    public MedicationLog save(MedicationLog log) {
        return medicationLogRepository.save(log);
    }


public void logMedicationStatus(Long clientId, String medicationName, String status) {
    List<ClientMedication> meds = clientMedicationRepository.findByClient_ClientId(clientId);

    Optional<ClientMedication> match = meds.stream()
        .filter(cm -> cm.getMedication().getName().equalsIgnoreCase(medicationName))
        .findFirst();

    if (match.isPresent()) {
        MedicationLog log = new MedicationLog();
        log.setClientMedication(match.get());
        log.setStatus(MedicationLog.Status.valueOf(status));  // Should be one of: Given, Skipped, Missed, Late
        log.setActualTime(LocalDateTime.now());
        log.setScheduledTime(LocalDateTime.now()); // or the intended time if tracked

        medicationLogRepository.save(log);
        System.out.println("✅ Medication log recorded.");
    } else {
        System.out.println("❌ Medication not found for client.");
    }
}



    public MedicationLog findById(Long id) {
        return medicationLogRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        medicationLogRepository.deleteById(id);
    }
}