package com.example.meditime.repository;

import com.example.meditime.model.MedicationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationLogRepository extends JpaRepository<MedicationLog, Long> {
}