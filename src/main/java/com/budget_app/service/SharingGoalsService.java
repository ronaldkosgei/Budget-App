package com.budget_app.service;

import com.budget_app.dto.SharingGoalsDto;
import com.budget_app.entity.SharingGoals;

import java.util.List;
import java.util.Optional;

public interface SharingGoalsService {


    SharingGoalsDto saveGoal(SharingGoalsDto sharingGoalsDto);

    Optional<SharingGoalsDto> getGoal(Long goalId);

    List<SharingGoalsDto> getAllGoals();

    Optional<SharingGoalsDto> updateGoal(Long goalId, SharingGoalsDto sharingGoalsDto);

    Optional<SharingGoalsDto> deleteGoal(Long goalId);
}
