/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */

package com.example.MediTime.controller;
import com.example.MediTime.dto.AdherenceLogDTO;
import com.example.MediTime.service.AdherenceLogService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amywi
 */
@RestController
@RequestMapping("/api/adherence")
public class AdherenceLogController {


    @GetMapping
    public List<AdherenceLogDTO> getAllLogs() {
        return AdherenceLogService.getAllLogs().stream()
            .map(AdherenceLogDTO::fromEntity)
            .toList();
    }
}


