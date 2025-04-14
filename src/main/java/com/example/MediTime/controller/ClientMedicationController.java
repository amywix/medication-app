//Amy Wickham 121785021
// Amy Wickham 12178502
// File: ClientMedicationController.java
// Description: See MediTime documentation. This file is part of the medication management system.

package com.example.meditime.controller;

import com.example.meditime.dto.ClientMedicationDTO;
import com.example.meditime.service.ClientMedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medication")
public class ClientMedicationController {

    private final ClientMedicationService clientMedicationService;

    @Autowired
    public ClientMedicationController(ClientMedicationService clientMedicationService) {
        this.clientMedicationService = clientMedicationService;
    }

    @PostMapping("/assign")
public ResponseEntity<String> assignMedication(@RequestBody ClientMedicationDTO dto) {
    clientMedicationService.assignMedication(dto);
    return ResponseEntity.ok("Medication assigned successfully.");
}


    @GetMapping("/schedule/{clientId}")
    public ResponseEntity<List<ClientMedicationDTO>> getClientSchedule(@PathVariable Long clientId) {
        List<ClientMedicationDTO> schedule = clientMedicationService.getClientMedicationDTOs(clientId);
        return ResponseEntity.ok(schedule);
    }

    @GetMapping("/adherence/{clientId}")
    public ResponseEntity<Double> getAdherenceRate(@PathVariable Long clientId) {
        double rate = clientMedicationService.calculateAdherenceRate(clientId);
        return ResponseEntity.ok(rate);
    }
}