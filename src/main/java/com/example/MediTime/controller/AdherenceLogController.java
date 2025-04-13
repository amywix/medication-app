package com.example.meditime.controller;

import com.example.meditime.model.AdherenceLog;
import com.example.meditime.service.AdherenceLogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author amywi
 */

@RestController
@RequestMapping("/api/adherence")
public class AdherenceLogController {

@Autowired
    private AdherenceLogService adherenceLogService;

    @GetMapping("/client/{clientMedicationId}")
    public ResponseEntity<List<AdherenceLog>> getLogs(@PathVariable Long clientMedicationId) {
        return ResponseEntity.ok(adherenceLogService.getLogsByClientMedicationId(clientMedicationId));
    }

    @PostMapping
    public ResponseEntity<?> logAdherence(@RequestBody AdherenceLog log) {
        adherenceLogService.logAdherence(log);
        return ResponseEntity.ok("Adherence logged.");
    }
}
