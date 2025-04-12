package com.example.MediTime.service;

import com.example.MediTime.model.MedicationInteraction;
import com.example.MediTime.repository.MedicationInteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationInteractionService {

    @Autowired
    private MedicationInteractionRepository medicationInteractionRepository;

    public List<MedicationInteraction> findAll() {
        return medicationInteractionRepository.findAll();
    }

    public MedicationInteraction save(MedicationInteraction interaction) {
        return medicationInteractionRepository.save(interaction);
    }

    public MedicationInteraction findById(Long id) {
        return medicationInteractionRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        medicationInteractionRepository.deleteById(id);
    }
}