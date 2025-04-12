package com.example.MediTime.folder;

import com.example.MediTime.model.Medication;
import com.example.MediTime.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }

    @PostMapping("/assign")
    public ResponseEntity<?> assignMedication(@RequestBody Medication medication) {
        medicationService.assignMedication(medication);
        return ResponseEntity.ok("Medication assigned successfully.");
    }
}