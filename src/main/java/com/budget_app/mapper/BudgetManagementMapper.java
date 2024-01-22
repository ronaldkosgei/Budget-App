package com.budget_app.mapper;

import com.budget_app.dto.BudgetManagementDto;
import com.budget_app.entity.BudgetManagement;
import org.springframework.stereotype.Component;

@Component
public class BudgetManagementMapper {

    public static BudgetManagement toEntity(BudgetManagementDto budgetManagementDto){
        BudgetManagement budgetManagement = new BudgetManagement();
        budgetManagement.setBudgetId(budgetManagementDto.getBudgetId());
        budgetManagement.setCategoryId(budgetManagementDto.getCategoryId());
        budgetManagement.setAmount(budgetManagementDto.getAmount());
        budgetManagement.setPeriod(budgetManagementDto.getPeriod());
        budgetManagement.setUserId(budgetManagementDto.getUserId());

        return budgetManagement;
    }

    public static BudgetManagementDto toDto(BudgetManagement budgetManagement){
        BudgetManagementDto budgetManagementDto = new BudgetManagementDto();
        budgetManagementDto.setBudgetId(budgetManagement.getBudgetId());
        budgetManagementDto.setCategoryId(budgetManagement.getCategoryId());
        budgetManagementDto.setAmount(budgetManagement.getAmount());
        budgetManagementDto.setPeriod(budgetManagement.getPeriod());
        budgetManagementDto.setUserId(budgetManagement.getUserId());

        return budgetManagementDto;
    }

    public static void updateEntity(BudgetManagementDto budgetManagementDto, BudgetManagement budgetManagement){
        budgetManagement.setCategoryId(budgetManagementDto.getCategoryId());
        budgetManagement.setAmount(budgetManagementDto.getAmount());
        budgetManagement.setPeriod(budgetManagementDto.getPeriod());
        budgetManagement.setUserId(budgetManagementDto.getUserId());
    }
}
