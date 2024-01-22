package com.budget_app.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class IncomeTrackingDto {

    private Long incomeId;

    private Double amount;

    private LocalDate earned_date;

    private String source;

    private String paymentMethod;

    private String comments;
}
