package com.budget_app.service;

import com.budget_app.dto.IncomeTrackingDto;

import java.util.List;
import java.util.Optional;

public interface IncomeTrackingService {

    IncomeTrackingDto saveIncome(IncomeTrackingDto incomeTrackingDto);

    Optional<IncomeTrackingDto> getIncomeById(Long incomeId);

    List<IncomeTrackingDto> getAllIncomeTrackings();

    Optional<IncomeTrackingDto> updateIncomeTracking(Long incomeId, IncomeTrackingDto incomeTrackingDto);

    Optional<Object> deleteIncomeTracking(Long incomeId);
}
