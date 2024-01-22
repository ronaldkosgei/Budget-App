package com.budget_app.dto;

import com.budget_app.enums.Status;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ReminderDto {

    private Long reminderId;

    private Long userId;

    private String reminderText;

    private LocalDate dueDate;

    private Status status;

    private String repeatInterval;
}
