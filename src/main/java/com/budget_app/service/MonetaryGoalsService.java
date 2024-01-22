package com.budget_app.service;

import com.budget_app.dto.MonetaryGoalsDto;
import com.budget_app.entity.MonetaryGoals;

import java.util.List;
import java.util.Optional;

public interface MonetaryGoalsService {

    MonetaryGoalsDto createMonetaryGoals(MonetaryGoalsDto monetaryGoalsDto);

    Optional<MonetaryGoalsDto> getMonetaryGoalsById(Long goalId);

    List<MonetaryGoalsDto> getAllMonetaryGoals();

    Optional<MonetaryGoalsDto> updateMonetaryGoals(Long goalId, MonetaryGoalsDto monetaryGoalsDto);

    Optional<MonetaryGoalsDto> deleteMonetaryGoalsById(Long goalId);
}
