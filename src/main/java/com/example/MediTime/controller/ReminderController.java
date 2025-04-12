package com.example.MediTime.controller;

import com.example.MediTime.model.Reminder;
import com.example.MediTime.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        return ResponseEntity.ok(reminderService.createReminder(reminder));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Reminder>> getRemindersForClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(reminderService.getRemindersByClientId(clientId));
    }
}
