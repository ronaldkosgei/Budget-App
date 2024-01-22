package com.budget_app.service;

import com.budget_app.dto.ReminderDto;
import com.budget_app.entity.Reminder;

import java.util.List;
import java.util.Optional;

public interface ReminderService {

    ReminderDto saveReminder(ReminderDto reminderDto);

    Optional<ReminderDto> getReminderById(Long reminderId);

    List<ReminderDto> getAllReminders();

    Optional<ReminderDto> updateReminder(Long reminderId, ReminderDto reminderDto);

    public Optional<ReminderDto> deleteReminderById(Long reminderId);

}
