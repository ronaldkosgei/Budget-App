package com.budget_app.service.impl;

import com.budget_app.dto.ReminderDto;
import com.budget_app.entity.Reminder;
import com.budget_app.mapper.ReminderMapper;
import com.budget_app.repository.ReminderRepository;
import com.budget_app.service.ReminderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository reminderRepository;

    private final ReminderMapper reminderMapper;

    public ReminderServiceImpl(ReminderRepository reminderRepository, ReminderMapper reminderMapper) {
        this.reminderRepository = reminderRepository;
        this.reminderMapper = reminderMapper;
    }

    @Override
    public ReminderDto saveReminder(ReminderDto reminderDto) {
        Reminder reminder = reminderMapper.toEntity(reminderDto);
        reminder = reminderRepository.save(reminder);
        return reminderMapper.toDto(reminder);
    }

    @Override
    public Optional<ReminderDto> getReminderById(Long reminderId) {
        try {
            Optional<Reminder> reminder = reminderRepository.findById(reminderId);
            if (reminder.isPresent()) {
                return Optional.of(reminderMapper.toDto(reminder.get()));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<ReminderDto> getAllReminders() {
        List<Reminder> reminders = reminderRepository.findAll();
        return reminders.stream()
                .map(ReminderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReminderDto> updateReminder(Long reminderId, ReminderDto reminderDto) {
        try {
            Optional<Reminder> reminderOptional = reminderRepository.findById(reminderId);
            if (reminderOptional.isPresent()){
                Reminder existingReminder = reminderOptional.get();
                Reminder updatedReminder = reminderRepository.save(existingReminder);
                return Optional.of(reminderMapper.toDto(updatedReminder));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ReminderDto> deleteReminderById(Long reminderId) {
        try {
            Optional<Reminder> reminderOptional = reminderRepository.findById(reminderId);
            if (reminderOptional.isPresent()){
                Reminder existingReminder = reminderOptional.get();
                reminderRepository.delete(existingReminder);
                return Optional.of(reminderMapper.toDto(existingReminder));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
