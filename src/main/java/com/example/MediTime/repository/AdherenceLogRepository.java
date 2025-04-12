package com.example.MediTime.repository;

import com.example.MediTime.model.AdherenceLog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdherenceLogRepository extends JpaRepository<AdherenceLog, Long> {

    List<AdherenceLog> findByClientMedicationClientMedicationId(Long id);

    

}