package com.budget_app.mapper;

import com.budget_app.dto.IncomeTrackingDto;
import com.budget_app.entity.IncomeTracking;
import org.springframework.stereotype.Component;

@Component
public class IncomeTrackingMapper {

    public static IncomeTracking toEntity(IncomeTrackingDto incomeTrackingDto){
        IncomeTracking incomeTracking = new IncomeTracking();
        incomeTracking.setIncomeId(incomeTrackingDto.getIncomeId());
        incomeTracking.setAmount(incomeTrackingDto.getAmount());
        incomeTracking.setEarned_date(incomeTrackingDto.getEarned_date());
        incomeTracking.setSource(incomeTrackingDto.getSource());
        incomeTracking.setPaymentMethod(incomeTrackingDto.getPaymentMethod());
        incomeTracking.setComments(incomeTrackingDto.getComments());

        return incomeTracking;
    }

    public static IncomeTrackingDto toDto(IncomeTracking incomeTracking) {
        IncomeTrackingDto incomeTrackingDto = new IncomeTrackingDto();
        incomeTrackingDto.setIncomeId(incomeTracking.getIncomeId());
        incomeTrackingDto.setAmount(incomeTracking.getAmount());
        incomeTrackingDto.setEarned_date(incomeTracking.getEarned_date());
        incomeTrackingDto.setSource(incomeTracking.getSource());
        incomeTrackingDto.setPaymentMethod(incomeTracking.getPaymentMethod());
        incomeTrackingDto.setComments(incomeTracking.getComments());

        return incomeTrackingDto;

    }

    public static void updateEntity(IncomeTrackingDto incomeTrackingDto, IncomeTracking incomeTracking) {
        incomeTracking.setAmount(incomeTrackingDto.getAmount());
        incomeTracking.setEarned_date(incomeTrackingDto.getEarned_date());
        incomeTracking.setSource(incomeTrackingDto.getSource());
        incomeTracking.setPaymentMethod(incomeTrackingDto.getPaymentMethod());
        incomeTracking.setComments(incomeTrackingDto.getComments());
    }
}
