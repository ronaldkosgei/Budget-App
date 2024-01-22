package com.budget_app.controller;


import com.budget_app.dto.BudgetManagementDto;
import com.budget_app.service.BudgetManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/budget")
public class BudgetManagementController {

    private final BudgetManagementService budgetManagementService;

    public BudgetManagementController(BudgetManagementService budgetManagementService) {
        this.budgetManagementService = budgetManagementService;
    }

    @PostMapping("/save")
    public BudgetManagementDto saveBudgetManagement(@RequestBody BudgetManagementDto budgetManagementDto) {
        return budgetManagementService.saveBudgetManagement(budgetManagementDto);
    }

    @GetMapping("/get/{budgetManagementId}")
    public Optional<BudgetManagementDto> getBudgetManagementById(@PathVariable Long budgetManagementId) {
        return budgetManagementService.getBudgetManagementById(budgetManagementId);
    }

    @GetMapping("/get/all")
    public List<BudgetManagementDto> getAllBudgetManagements() {
        return budgetManagementService.getAllBudgetManagements();
    }

    @PutMapping("/update/{budgetManagementId}")
    public Optional<BudgetManagementDto> updateBudgetManagement(@PathVariable Long budgetManagementId,
                                                                @RequestBody BudgetManagementDto budgetManagementDto) {
        return budgetManagementService.updateBudgetManagement(budgetManagementId, budgetManagementDto);
    }

    @DeleteMapping("/delete/{budgetManagementId}")
    public void deleteBudgetManagement(@PathVariable Long budgetManagementId) {
        budgetManagementService.deleteBudgetManagement(budgetManagementId);
    }
}
