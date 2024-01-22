package com.budget_app.controller;

import com.budget_app.dto.ReminderDto;
import com.budget_app.service.ReminderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reminder")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping("/create")
    public ReminderDto saveReminder(@RequestBody ReminderDto reminderDto) {
        return reminderService.saveReminder(reminderDto);
    }

    @GetMapping("/{reminderId}")
    public Optional<ReminderDto> getReminderById(@PathVariable Long reminderId) {
        return reminderService.getReminderById(reminderId);
    }

    @GetMapping("/all")
    public List<ReminderDto> getAllReminders() {
        return reminderService.getAllReminders();
    }

    @PutMapping("/update/{reminderId}")
    public Optional<ReminderDto> updateReminder(@PathVariable Long reminderId, @RequestBody ReminderDto reminderDto) {
        return reminderService.updateReminder(reminderId,reminderDto);
    }

    @DeleteMapping("/delete/{reminderId}")
    public void deleteReminderById(@PathVariable Long reminderId) {
        reminderService.deleteReminderById(reminderId);
    }

}
