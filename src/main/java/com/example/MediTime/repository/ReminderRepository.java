package com.example.MediTime.repository;

import com.example.MediTime.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByClientMedication_Client_ClientId(Long clientId);

    public Reminder save(Reminder reminder);
}
