package com.example.meditime.repository;

import com.example.meditime.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByClientMedication_Client_ClientId(Long clientId);

    public Reminder save(Reminder reminder);
}
