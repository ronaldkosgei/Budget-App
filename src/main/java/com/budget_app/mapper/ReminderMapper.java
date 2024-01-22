package com.budget_app.mapper;

import com.budget_app.dto.ReminderDto;
import com.budget_app.entity.Reminder;
import org.springframework.stereotype.Component;

@Component
public class ReminderMapper {

    public static Reminder toEntity(ReminderDto reminderDto){
        Reminder reminder = new Reminder();
        reminder.setReminderId(reminderDto.getReminderId());
        reminder.setUserId(reminderDto.getUserId());
        reminder.setReminderText(reminderDto.getReminderText());
        reminder.setDueDate(reminderDto.getDueDate());
        reminder.setStatus(reminderDto.getStatus());
        reminder.setRepeatInterval(reminderDto.getRepeatInterval());

        return reminder;
    }

    public static ReminderDto toDto(Reminder reminder) {
        ReminderDto reminderDto = new ReminderDto();
        reminderDto.setReminderId(reminder.getReminderId());
        reminderDto.setUserId(reminder.getUserId());
        reminderDto.setReminderText(reminder.getReminderText());
        reminderDto.setDueDate(reminder.getDueDate());
        reminderDto.setStatus(reminder.getStatus());
        reminderDto.setRepeatInterval(reminder.getRepeatInterval());

        return reminderDto;
    }

    public static void updateEntity(Reminder reminder, ReminderDto reminderDto) {
        reminder.setUserId(reminderDto.getUserId());
        reminder.setReminderText(reminderDto.getReminderText());
        reminder.setDueDate(reminderDto.getDueDate());
        reminder.setStatus(reminderDto.getStatus());
        reminder.setRepeatInterval(reminderDto.getRepeatInterval());
    }
}
