/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.meditime.repository;

/**
 *
 * @author amywi
 */
import com.example.meditime.model.ClientMedication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientMedicationRepository extends JpaRepository<ClientMedication, Long> {
    List<ClientMedication> findByClient_ClientId(Long clientId);
}