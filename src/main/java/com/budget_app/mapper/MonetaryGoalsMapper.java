package com.budget_app.mapper;

import com.budget_app.dto.MonetaryGoalsDto;
import com.budget_app.entity.MonetaryGoals;
import org.springframework.stereotype.Component;

@Component
public class MonetaryGoalsMapper {

    public static MonetaryGoals toEntity(MonetaryGoalsDto monetaryGoalsDto){
        MonetaryGoals monetaryGoals = new MonetaryGoals();
        monetaryGoals.setGoalId(monetaryGoalsDto.getGoalId());
        monetaryGoals.setUserId(monetaryGoals.getUserId());
        monetaryGoals.setGoalAmount(monetaryGoalsDto.getGoalAmount());
        monetaryGoals.setCurrentAmount(monetaryGoalsDto.getCurrentAmount());
        monetaryGoals.setTargetAmount(monetaryGoalsDto.getTargetAmount());
        monetaryGoals.setCategoryId(monetaryGoalsDto.getCategoryId());
        monetaryGoals.setComments(monetaryGoalsDto.getComments());

        return monetaryGoals;
    }

    public static MonetaryGoalsDto toDto(MonetaryGoals monetaryGoals){
        MonetaryGoalsDto monetaryGoalsDto = new MonetaryGoalsDto();
        monetaryGoalsDto.setGoalId(monetaryGoals.getGoalId());
        monetaryGoalsDto.setUserId(monetaryGoals.getUserId());
        monetaryGoalsDto.setGoalAmount(monetaryGoals.getGoalAmount());
        monetaryGoalsDto.setCurrentAmount(monetaryGoals.getCurrentAmount());
        monetaryGoalsDto.setTargetAmount(monetaryGoals.getTargetAmount());
        monetaryGoalsDto.setCategoryId(monetaryGoals.getCategoryId());
        monetaryGoalsDto.setComments(monetaryGoals.getComments());

        return monetaryGoalsDto;
    }

    public static void updateEntity(MonetaryGoals monetaryGoals, MonetaryGoalsDto monetaryGoalsDto){
        monetaryGoals.setUserId(monetaryGoalsDto.getUserId());
        monetaryGoals.setGoalAmount(monetaryGoalsDto.getGoalAmount());
        monetaryGoals.setCurrentAmount(monetaryGoalsDto.getCurrentAmount());
        monetaryGoals.setTargetAmount(monetaryGoalsDto.getTargetAmount());
        monetaryGoals.setCategoryId(monetaryGoalsDto.getCategoryId());
        monetaryGoals.setComments(monetaryGoalsDto.getComments());
    }
}
