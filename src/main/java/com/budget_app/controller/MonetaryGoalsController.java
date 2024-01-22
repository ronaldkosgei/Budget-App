package com.budget_app.controller;


import com.budget_app.dto.MonetaryGoalsDto;
import com.budget_app.service.MonetaryGoalsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monetary")
public class MonetaryGoalsController {

    private final MonetaryGoalsService monetaryGoalsService;

    public MonetaryGoalsController(MonetaryGoalsService monetaryGoalsService) {
        this.monetaryGoalsService = monetaryGoalsService;
    }

    @PostMapping("/create")
    public MonetaryGoalsDto createMonetaryGoals(@RequestBody MonetaryGoalsDto monetaryGoalsDto) {
        return monetaryGoalsService.createMonetaryGoals(monetaryGoalsDto);
    }

    @GetMapping("/get/{goalId}")
    public Optional<MonetaryGoalsDto> getMonetaryGoalsById(@PathVariable Long goalId) {
        return monetaryGoalsService.getMonetaryGoalsById(goalId);
    }

    @GetMapping("/get/all")
    public List<MonetaryGoalsDto> getAllMonetaryGoals() {
        return monetaryGoalsService.getAllMonetaryGoals();
    }

    @PutMapping("/update/{goalId}")
    public Optional<MonetaryGoalsDto> updateMonetaryGoals(@RequestParam Long goalId, @RequestBody MonetaryGoalsDto monetaryGoalsDto) {
        return monetaryGoalsService.updateMonetaryGoals(goalId, monetaryGoalsDto);
    }

    @DeleteMapping("/delete/{goalId}")
    public Optional<MonetaryGoalsDto> deleteMonetaryGoalsById(@PathVariable Long goalId) {
        return monetaryGoalsService.deleteMonetaryGoalsById(goalId);
    }
}
