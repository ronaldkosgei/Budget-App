package com.budget_app.dto;


import com.budget_app.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class AlertScannerDto {

    private Long alertId;

    private Long userId;

    private String alertText;

    private LocalDate createdAt;

    private Status status;

}
