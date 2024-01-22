package com.budget_app.controller;


import com.budget_app.dto.ExpenseTrackingDto;
import com.budget_app.service.ExpenseTrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expense")
public class ExpenseTrackingController {

    private final ExpenseTrackingService expenseTrackingService;

    public ExpenseTrackingController(ExpenseTrackingService expenseTrackingService) {
        this.expenseTrackingService = expenseTrackingService;
    }

    @PostMapping("/add")
    public ExpenseTrackingDto saveExpenseTracking(@RequestBody ExpenseTrackingDto expenseTrackingDto) {
        return expenseTrackingService.saveExpenseTracking(expenseTrackingDto);
    }

    @GetMapping("/get/{expenseId}")
    public Optional<ExpenseTrackingDto> getExpenseTrackingById(@PathVariable("expenseId") Long expenseId) {
        return expenseTrackingService.getExpenseTrackingById(expenseId);
    }

    @GetMapping("/get")
    public List<ExpenseTrackingDto> getAllExpenseTrackings() {
        return expenseTrackingService.getAllExpenseTrackings();
    }

    @PutMapping("/update/{expenseId}")
    public Optional<ExpenseTrackingDto> updateExpenseTracking(@PathVariable("expenseId") Long expenseId, @RequestBody ExpenseTrackingDto expenseTrackingDto) {
        return expenseTrackingService.updateExpenseTracking(expenseId, expenseTrackingDto);
    }

    @DeleteMapping("/delete/{expenseId}")
    public Optional<Object> deleteExpenseTracking(@PathVariable("expenseId") Long expenseId) {
        return expenseTrackingService.deleteExpenseTracking(expenseId);
    }
}
