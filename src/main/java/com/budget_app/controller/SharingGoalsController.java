package com.budget_app.controller;

import com.budget_app.dto.SharingGoalsDto;
import com.budget_app.service.SharingGoalsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sharing")
public class SharingGoalsController {

    private final SharingGoalsService sharingGoalsService;

    public SharingGoalsController(SharingGoalsService sharingGoalsService) {
        this.sharingGoalsService = sharingGoalsService;
    }

    @PostMapping("/goal")
    public SharingGoalsDto saveGoal(@RequestBody SharingGoalsDto sharingGoalsDto) {
        return sharingGoalsService.saveGoal(sharingGoalsDto);
    }

    @GetMapping("/goal/{goalId}")
    public Optional<SharingGoalsDto> getGoal(@PathVariable Long goalId) {
        return sharingGoalsService.getGoal(goalId);
    }

    @GetMapping("/goal/all")
    public List<SharingGoalsDto> getAllGoals() {
        return sharingGoalsService.getAllGoals();
    }

    @PutMapping("/goal/{goalId}")
    public Optional<SharingGoalsDto> updateGoal(@PathVariable Long goalId, @RequestBody SharingGoalsDto sharingGoalsDto) {
        return sharingGoalsService.updateGoal(goalId, sharingGoalsDto);
    }

    @DeleteMapping("/goal/{goalId}")
    public Optional<SharingGoalsDto> deleteGoal(@PathVariable Long goalId) {
        return sharingGoalsService.deleteGoal(goalId);
    }
}

