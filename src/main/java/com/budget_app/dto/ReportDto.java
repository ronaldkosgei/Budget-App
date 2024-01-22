package com.budget_app.dto;

import com.budget_app.enums.Status;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Setter
@Getter
public class ReportDto {


    private Long reportId;

    private Long userId;

    private String reportName;

    private LocalDate createdAt;

    private Status status;
}
