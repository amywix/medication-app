package com.example.meditime.repository;

import com.example.meditime.model.MedicationInteraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationInteractionRepository extends JpaRepository<MedicationInteraction, Long> {
}