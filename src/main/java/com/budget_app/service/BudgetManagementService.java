package com.budget_app.service;

import com.budget_app.dto.AlertScannerDto;
import com.budget_app.dto.BudgetManagementDto;
import com.budget_app.entity.BudgetManagement;

import java.util.List;
import java.util.Optional;

public interface BudgetManagementService {

    BudgetManagementDto saveBudgetManagement(BudgetManagementDto budgetManagementDto);

    Optional<BudgetManagementDto> getBudgetManagementById(Long budgetManagementId);

    List<BudgetManagementDto> getAllBudgetManagements();

    Optional<BudgetManagementDto> updateBudgetManagement(Long budgetManagementId, BudgetManagementDto budgetManagementDto);

    Optional<Object> deleteBudgetManagement(Long budgetManagementId);
}


