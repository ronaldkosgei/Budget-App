package com.budget_app.entity;

import com.budget_app.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_reminders")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long reminderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "reminder_text")
    private String reminderText;

    @Column(name = "due_at")
    private LocalDate dueDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "repeat_interval")
    private String repeatInterval;
}
