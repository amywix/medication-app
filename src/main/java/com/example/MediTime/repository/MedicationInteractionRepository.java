//Amy Wickham 121785021
package com.example.meditime.repository;

import com.example.meditime.model.Medication;
import com.example.meditime.model.MedicationInteraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicationInteractionRepository extends JpaRepository<MedicationInteraction, Long> {

    // Return interactions for a given medication (both sides)
  //  List<MedicationInteraction> findByMedicationId_1AndMedicationId_2(Long medicationId_1, Long medicationId_2);

    // Check if two medications interact (specific pair)

    
  Optional<MedicationInteraction> findByMedication1MedicationIdAndMedication2MedicationId(Medication med1, Medication med2);
Optional<MedicationInteraction> findByMedication1MedicationIdAndMedication2MedicationId(Long med1Id, Long med2Id);


    
}
