package com.example.meditime.dto;

import lombok.Data;
import com.example.meditime.model.MedicationInteraction;

@Data
public class MedicationInteractionDTO {
    private Long interactionId;
    private String medicationA;
    private String medicationB;
    private String interactionDescription;
    private String severity;

    public static MedicationInteractionDTO fromEntity(MedicationInteraction interaction) {
        if (interaction == null) return null;
        MedicationInteractionDTO dto = new MedicationInteractionDTO();
        dto.setInteractionId(interaction.getInteractionId());
        dto.setMedicationA(interaction.getMedicationId_1());
        dto.setMedicationB(interaction.getMedicationId_2());
        dto.setInteractionDescription(interaction.getInteractionDescription());
        dto.setSeverity(interaction.getSeverity().name());
        return dto;
    }
}