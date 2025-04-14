//Amy Wickham 121785021

// File: MedicationInteractionDTO.java


package com.example.meditime.dto;

import com.example.meditime.model.Medication;
import lombok.Data;
import com.example.meditime.model.MedicationInteraction;

@Data
public class MedicationInteractionDTO {
    private Long interactionId;
    private Medication medicationA;
    private Medication medicationB;
    private String interactionDescription;
    private String severity;

    public static MedicationInteractionDTO fromEntity(MedicationInteraction interaction) {
        if (interaction == null) return null;
        MedicationInteractionDTO dto = new MedicationInteractionDTO();
        dto.setInteractionId(interaction.getInteractionId());
        dto.setMedicationA(interaction.getMedication1());
        dto.setMedicationB(interaction.getMedication2());
        dto.setInteractionDescription(interaction.getInteractionDescription());
        dto.setSeverity(interaction.getSeverity().name());
        return dto;
    }
}