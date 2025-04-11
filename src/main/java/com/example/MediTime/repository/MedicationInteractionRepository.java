package com.example.MediTime.repository;

import com.example.MediTime.model.MedicationInteraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationInteractionRepository extends JpaRepository<MedicationInteraction, Long> {
}