//Amy Wickham 121785021
package com.example.meditime.repository;

import com.example.meditime.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    
    Optional<Medication> findByName(String name);
}
