package com.budget_app.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class SharingGoalsDto {

    private Long goalId;

    private Long userId;

    private Double goalAmount;

    private Double currentAmount;

    private Double targetAmount;

    private Long categoryId;

    private String comments;

    private String shareUrl;
}
