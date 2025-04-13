package com.example.meditime.dto;

import lombok.Data;
import com.example.meditime.model.AdherenceLog;

@Data
public class AdherenceLogDTO {
    private Long adherenceId;
    private String userFullName;
    private String clientMedicationName;
    private String checkedTime;
    private Double adherenceRate;

    public static AdherenceLogDTO fromEntity(AdherenceLog log) {
        if (log == null) return null;
        AdherenceLogDTO dto = new AdherenceLogDTO();
        dto.setAdherenceId(log.getAdherenceId());
        dto.setUserFullName(log.getUser().getName());
        dto.setClientMedicationName(log.getClientMedication().getMedication().getName());
        dto.setCheckedTime(log.getCheckedTime().toString());
        dto.setAdherenceRate(log.getAdherenceRate());
        return dto;
    }
}