package com.budget_app.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ExpenseTrackingDto {

    private Long expenseId;

    private Double amount;

    private LocalDate createdDate;

    private Long categoryId;

    private String url;

    private String comments;
}
