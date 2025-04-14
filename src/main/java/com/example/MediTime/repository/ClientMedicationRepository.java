//Amy Wickham 121785021
package com.example.meditime.repository;


import com.example.meditime.model.ClientMedication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientMedicationRepository extends JpaRepository<ClientMedication, Long> {
    List<ClientMedication> findByClient_ClientId(Long clientId);
    Optional<ClientMedication> findByClient_ClientIdAndMedication_MedicationId(Long clientId, Long medicationId);
@Query("SELECT cm.medication.id FROM ClientMedication cm WHERE cm.client.clientId = :clientId")
List<Long> findMedicationIdsByClientId(@Param("clientId") Long clientId);
}
