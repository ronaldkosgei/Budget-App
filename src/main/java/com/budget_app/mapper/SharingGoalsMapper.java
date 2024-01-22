package com.budget_app.mapper;

import com.budget_app.dto.SharingGoalsDto;
import com.budget_app.entity.SharingGoals;
import org.springframework.stereotype.Component;

@Component
public class SharingGoalsMapper {

    public static SharingGoals toEntity(SharingGoalsDto sharingGoalsDto){
        SharingGoals sharingGoals = new SharingGoals();
        sharingGoals.setGoalId(sharingGoalsDto.getGoalId());
        sharingGoals.setUserId(sharingGoals.getUserId());
        sharingGoals.setGoalAmount(sharingGoalsDto.getGoalAmount());
        sharingGoals.setCurrentAmount(sharingGoalsDto.getCurrentAmount());
        sharingGoals.setTargetAmount(sharingGoals.getTargetAmount());
        sharingGoals.setCategoryId(sharingGoalsDto.getCategoryId());
        sharingGoals.setComments(sharingGoalsDto.getComments());
        sharingGoals.setShareUrl(sharingGoalsDto.getShareUrl());

        return sharingGoals;
    }

    public static SharingGoalsDto toDto(SharingGoals sharingGoals){
        SharingGoalsDto sharingGoalsDto = new SharingGoalsDto();
        sharingGoalsDto.setGoalId(sharingGoals.getGoalId());
        sharingGoalsDto.setUserId(sharingGoals.getUserId());
        sharingGoalsDto.setGoalAmount(sharingGoals.getGoalAmount());
        sharingGoalsDto.setCurrentAmount(sharingGoals.getCurrentAmount());
        sharingGoalsDto.setTargetAmount(sharingGoals.getTargetAmount());
        sharingGoalsDto.setCategoryId(sharingGoals.getCategoryId());
        sharingGoalsDto.setComments(sharingGoals.getComments());
        sharingGoalsDto.setShareUrl(sharingGoals.getShareUrl());

        return sharingGoalsDto;
    }

    public static void updateEntity(SharingGoals sharingGoals, SharingGoalsDto sharingGoalsDto){
        sharingGoals.setUserId(sharingGoalsDto.getUserId());
        sharingGoals.setGoalAmount(sharingGoalsDto.getGoalAmount());
        sharingGoals.setCurrentAmount(sharingGoalsDto.getCurrentAmount());
        sharingGoals.setTargetAmount(sharingGoalsDto.getTargetAmount());
        sharingGoals.setCategoryId(sharingGoalsDto.getCategoryId());
        sharingGoals.setComments(sharingGoalsDto.getComments());
        sharingGoals.setShareUrl(sharingGoalsDto.getShareUrl());
    }
}
