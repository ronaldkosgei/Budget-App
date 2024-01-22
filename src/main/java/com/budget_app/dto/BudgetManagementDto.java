package com.budget_app.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BudgetManagementDto {

    private Long budgetId;

    private Long categoryId;

    private Double amount;

    private String period;

    private Long userId;
}
