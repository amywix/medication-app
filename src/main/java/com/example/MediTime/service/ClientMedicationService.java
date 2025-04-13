
package com.example.meditime.service;

import com.example.meditime.dto.ClientMedicationDTO;
import com.example.meditime.model.Client;
import com.example.meditime.model.ClientMedication;
import com.example.meditime.model.Medication;
import com.example.meditime.model.MedicationLog;
import com.example.meditime.model.User;
import com.example.meditime.repository.ClientMedicationRepository;
import com.example.meditime.repository.ClientRepository;
import com.example.meditime.repository.MedicationLogRepository;
import com.example.meditime.repository.MedicationRepository;
import com.example.meditime.repository.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author amywi
 */
@Service
public class ClientMedicationService {

    private final ClientMedicationRepository medicationRepository;
    private final ClientRepository clientRepository;
    private final MedicationRepository medicationRepositoryRef;
     private final UserRepository userRepository;
     private final MedicationLogRepository medicationLogRepository;

   public ClientMedicationService(
    ClientMedicationRepository medicationRepository,
    ClientRepository clientRepository,
    MedicationRepository medicationRepositoryRef,
    UserRepository userRepository,
    MedicationLogRepository medicationLogRepository
) {
    this.medicationRepository = medicationRepository;
    this.clientRepository = clientRepository;
    this.medicationRepositoryRef = medicationRepositoryRef;
    this.userRepository = userRepository;
    this.medicationLogRepository = medicationLogRepository;
}


    public ClientMedication createSchedule(Long clientId, Long medicationId, String dosage, String frequency, LocalDate startDate, LocalDate endDate) {
        Optional<Client> client = clientRepository.findById(clientId);
        Optional<Medication> medication = medicationRepositoryRef.findById(medicationId);

        if (client.isPresent() && medication.isPresent()) {
            ClientMedication cm = new ClientMedication();
            cm.setClient(client.get());
            cm.setMedication(medication.get());
            cm.setDosage(dosage);
            cm.setFrequency(frequency);
            cm.setStartDate(startDate);
            cm.setEndDate(endDate);
            return medicationRepository.save(cm);
        }
        return null;
    }

    public ClientMedication updateSchedule(Long id, String dosage, String frequency, LocalDate startDate, LocalDate endDate) {
        Optional<ClientMedication> optional = medicationRepository.findById(id);
        if (optional.isPresent()) {
            ClientMedication cm = optional.get();
            cm.setDosage(dosage);
            cm.setFrequency(frequency);
            cm.setStartDate(startDate);
            cm.setEndDate(endDate);
            return medicationRepository.save(cm);
        }
        return null;
    }

    public boolean deleteSchedule(Long id) {
        if (medicationRepository.existsById(id)) {
            medicationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<ClientMedication> getSchedulesForClient(Long clientId) {
        return medicationRepository.findByClient_ClientId(clientId);
    }
    // --- Drug Interaction Check ---
    public List<String> checkDrugInteractions(Long clientId, Long newMedicationId) {
        Optional<Medication> newMedicationOpt = medicationRepositoryRef.findById(newMedicationId);
        if (newMedicationOpt.isEmpty()) return Collections.emptyList();

        Medication newMedication = newMedicationOpt.get();
        Set<String> interactions = new HashSet<>(Arrays.asList(newMedication.getInteractionInfo().split(",")));

        List<ClientMedication> currentMeds = medicationRepository.findByClient_ClientId(clientId);
        List<String> conflicts = new ArrayList<>();

        for (ClientMedication cm : currentMeds) {
            String currentName = cm.getMedication().getName();
            if (interactions.contains(currentName)) {
                conflicts.add(currentName);
            }
        }
        return conflicts;
    }

    // --- Side Effects Warning ---
    public List<String> getSignificantSideEffects(Long medicationId) {
        Optional<Medication> medicationOpt = medicationRepositoryRef.findById(medicationId);
        if (medicationOpt.isEmpty()) return Collections.emptyList();

        Medication medication = medicationOpt.get();
        return Arrays.asList(medication.getSideEffects().split(","));
    }

    public List<ClientMedicationDTO> getClientMedicationDTOs(Long clientId) {
    List<ClientMedication> entities = medicationRepository.findByClient_ClientId(clientId);
    return entities.stream().map(cm -> new ClientMedicationDTO(
            cm.getMedication().getName(),
            cm.getDosage(),
            cm.getFrequency(),
            cm.getStartDate().toString(),
            cm.getEndDate().toString()
    )).toList();
}
public void logMedicationAction(
        Long clientMedicationId,
        Long carerId,
        MedicationLog.Status status,
        LocalDateTime scheduledTime,
        LocalDateTime actualTime,
        String notes
) {
    MedicationLog log = new MedicationLog();

    ClientMedication clientMedication = medicationRepository.findById(clientMedicationId)
            .orElseThrow(() -> new RuntimeException("ClientMedication not found"));

    User carer = userRepository.findById(carerId)
            .orElseThrow(() -> new RuntimeException("Carer not found"));

    log.setClientMedication(clientMedication);
    log.setCarer(carer);
    log.setStatus(status);
    log.setScheduledTime(scheduledTime);
    log.setActualTime(actualTime);
    log.setNotes(notes);

    medicationLogRepository.save(log);
}


}