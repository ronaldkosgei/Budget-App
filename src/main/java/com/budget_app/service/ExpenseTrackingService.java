package com.budget_app.service;

import com.budget_app.dto.ExpenseTrackingDto;
import com.budget_app.entity.ExpenseTracking;

import java.util.List;
import java.util.Optional;

public interface ExpenseTrackingService {

    ExpenseTrackingDto saveExpenseTracking(ExpenseTrackingDto expenseTrackingDto);

    Optional<ExpenseTrackingDto> getExpenseTrackingById(Long expenseId);

    List<ExpenseTrackingDto> getAllExpenseTrackings();

    Optional<ExpenseTrackingDto> updateExpenseTracking(Long expenseId, ExpenseTrackingDto expenseTrackingDto);

    Optional<Object> deleteExpenseTracking(Long expenseId);
}
