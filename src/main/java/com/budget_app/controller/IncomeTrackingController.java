package com.budget_app.controller;

import com.budget_app.dto.IncomeTrackingDto;
import com.budget_app.entity.IncomeTracking;
import com.budget_app.service.IncomeTrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/income")
public class IncomeTrackingController {

    private final IncomeTrackingService incomeTrackingService;

    public IncomeTrackingController(IncomeTrackingService incomeTrackingService) {
        this.incomeTrackingService = incomeTrackingService;
    }

    @PostMapping("/save")
    public IncomeTrackingDto saveIncome(@RequestBody IncomeTrackingDto incomeTrackingDto) {
        return incomeTrackingService.saveIncome(incomeTrackingDto);
    }

    @GetMapping("/get/{incomeId}")
    public Optional<IncomeTrackingDto> getIncomeById(@PathVariable Long incomeId) {
        return incomeTrackingService.getIncomeById(incomeId);
    }

    @GetMapping("/get/all")
    public java.util.List<IncomeTrackingDto> getAllIncomeTrackings() {
        return incomeTrackingService.getAllIncomeTrackings();
    }

    @PutMapping("/update/{incomeId}")
    public Optional<IncomeTrackingDto> updateIncomeTracking(@PathVariable Long incomeId, @RequestBody IncomeTrackingDto incomeTrackingDto) {
        return incomeTrackingService.updateIncomeTracking(incomeId, incomeTrackingDto);
    }

    @DeleteMapping("/delete/{incomeId}")
    public Optional<Object> deleteIncomeTracking(@PathVariable Long incomeId) {
        return incomeTrackingService.deleteIncomeTracking(incomeId);
    }
}
