//Amy Wickham 121785021
package com.example.meditime.service;

import com.example.meditime.model.MedicationInteraction;
import com.example.meditime.repository.ClientMedicationRepository;
import com.example.meditime.repository.MedicationInteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationInteractionService {

    @Autowired
    private MedicationInteractionRepository medicationInteractionRepository;
 @Autowired
    private ClientMedicationRepository clientMedicationRepository;
    public List<MedicationInteraction> findAll() {
        return medicationInteractionRepository.findAll();
    }

    public MedicationInteraction save(MedicationInteraction interaction) {
        return medicationInteractionRepository.save(interaction);
    }

    public MedicationInteraction findById(Long id) {
        return medicationInteractionRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        medicationInteractionRepository.deleteById(id);
    }
    
    public boolean checkInteractions(Long clientId, Long newMedId) {
    List<Long> existingMedIds = clientMedicationRepository.findMedicationIdsByClientId(clientId);

    for (Long existingMedId : existingMedIds) {
        // Check both ways: A-B and B-A
        Optional<MedicationInteraction> interaction =
                medicationInteractionRepository.findByMedication1MedicationIdAndMedication2MedicationId(existingMedId, newMedId);

        if (interaction.isEmpty()) {
            interaction = medicationInteractionRepository.findByMedication1MedicationIdAndMedication2MedicationId(newMedId, existingMedId);
        }

        if (interaction.isPresent()) {
            return true; //Interaction found
        }
    }

    return false; // No interactions
}



}