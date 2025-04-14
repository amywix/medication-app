//Amy Wickham 121785021
package com.example.meditime.repository;

import com.example.meditime.model.MedicationLog;
import com.example.meditime.model.MedicationLog.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationLogRepository extends JpaRepository<MedicationLog, Long> {

    // Get all logs for a specific client
    List<MedicationLog> findByClientMedication_Client_ClientId(Long clientId);

    // Count how many medications were marked with a certain status for a client
    long countByClientMedication_Client_ClientIdAndStatus(Long clientId, Status status);

    // Optional: fetch logs by client and medication name if needed
    List<MedicationLog> findByClientMedication_Client_ClientIdAndClientMedication_Medication_Name(Long clientId, String medicationName);
}
