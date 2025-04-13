package com.example.meditime.repository;

import com.example.meditime.model.AdherenceLog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdherenceLogRepository extends JpaRepository<AdherenceLog, Long> {

    List<AdherenceLog> findByClientMedicationClientMedicationId(Long id);

    

}