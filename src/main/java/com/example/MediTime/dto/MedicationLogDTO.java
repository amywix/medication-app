package com.example.meditime.dto;

import lombok.Data;
import com.example.meditime.model.MedicationLog;

@Data
public class MedicationLogDTO {
    private Long logId;
    private String carerName;
    private String status;
    private String scheduledTime;
    private String actualTime;

    public static MedicationLogDTO fromEntity(MedicationLog log) {
        if (log == null) return null;
        MedicationLogDTO dto = new MedicationLogDTO();
        dto.setLogId(log.getLogId());
        dto.setCarerName(log.getCarer().getName());
        dto.setStatus(log.getStatus().name());
        dto.setScheduledTime(log.getScheduledTime().toString());
        dto.setActualTime(log.getActualTime().toString());
        return dto;
    }
}