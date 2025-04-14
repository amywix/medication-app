//Amy Wickham 121785021
package com.example.meditime.service;

import com.example.meditime.dto.ClientMedicationDTO;
import com.example.meditime.model.Client;
import com.example.meditime.model.ClientMedication;
import com.example.meditime.model.Medication;
import com.example.meditime.model.MedicationLog;
import com.example.meditime.repository.ClientMedicationRepository;
import com.example.meditime.repository.ClientRepository;
import com.example.meditime.repository.MedicationLogRepository;
import com.example.meditime.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientMedicationService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private MedicationLogRepository medicationLogRepository;
    @Autowired
    private ClientMedicationRepository clientMedicationRepository;

    public void assignMedication(ClientMedicationDTO dto) {
        Optional<Client> clientOpt = clientRepository.findById(dto.getClientId());
        Optional<Medication> medicationOpt = medicationRepository.findById(dto.getMedicationId());

        if (clientOpt.isPresent() && medicationOpt.isPresent()) {
            ClientMedication cm = new ClientMedication();
            cm.setClient(clientOpt.get());
            cm.setMedication(medicationOpt.get());
            cm.setDosage(dto.getDosage());
            cm.setFrequency(dto.getFrequency());
            cm.setStartDate(dto.getStartDate());
            cm.setEndDate(dto.getEndDate());

            clientMedicationRepository.save(cm);
            System.out.println("Medication schedule assigned successfully.");
        } else {
            System.out.println("Client or Medication not found.");
        }
    }

    public List<ClientMedicationDTO> getClientMedicationDTOs(Long clientId) {
        List<ClientMedication> meds = clientMedicationRepository.findByClient_ClientId(clientId);
        List<ClientMedicationDTO> dtos = new ArrayList<>();

        for (ClientMedication cm : meds) {
            ClientMedicationDTO dto = new ClientMedicationDTO();
            dto.setMedicationName(cm.getMedication().getName());
            dto.setDosage(cm.getDosage());
            dto.setFrequency(cm.getFrequency());
            dto.setStartDate(cm.getStartDate());
            dto.setEndDate(cm.getEndDate());
            dtos.add(dto);
        }

        return dtos;
    }
     public double calculateAdherenceRate(Long clientId) {
    // Get all medication logs for this client's medications
    List<MedicationLog> logs = medicationLogRepository.findByClientMedication_Client_ClientId(clientId);

    if (logs.isEmpty()) {
        return 0.0;
    }

    long totalDoses = logs.size();
    long givenDoses = logs.stream()
            .filter(log -> log.getStatus() == MedicationLog.Status.Given)
            .count();

    return ((double) givenDoses / totalDoses) * 100;
}

}
