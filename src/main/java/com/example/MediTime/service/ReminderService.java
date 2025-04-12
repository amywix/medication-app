package com.example.MediTime.service;

import com.example.MediTime.model.Reminder;
import com.example.MediTime.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public List<Reminder> getRemindersByClientId(Long clientId) {
        return reminderRepository.findByClientMedication_Client_ClientId(clientId);
    }
}
