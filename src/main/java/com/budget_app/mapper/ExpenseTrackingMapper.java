package com.budget_app.mapper;

import com.budget_app.dto.ExpenseTrackingDto;
import com.budget_app.entity.ExpenseTracking;
import org.springframework.stereotype.Component;

@Component
public class ExpenseTrackingMapper {

    public static ExpenseTracking toEntity(ExpenseTrackingDto expenseTrackingDto){
        ExpenseTracking expenseTracking = new ExpenseTracking();
        expenseTracking.setExpenseId(expenseTrackingDto.getExpenseId());
        expenseTracking.setAmount(expenseTrackingDto.getAmount());
        expenseTracking.setCreatedDate(expenseTrackingDto.getCreatedDate());
        expenseTracking.setCategoryId(expenseTrackingDto.getCategoryId());
        expenseTracking.setUrl(expenseTrackingDto.getUrl());
        expenseTracking.setComments(expenseTrackingDto.getComments());

        return expenseTracking;
    }

    public static ExpenseTrackingDto toDto(ExpenseTracking expenseTracking){
        ExpenseTrackingDto expenseTrackingDto = new ExpenseTrackingDto();
        expenseTrackingDto.setExpenseId(expenseTracking.getExpenseId());
        expenseTrackingDto.setAmount(expenseTracking.getAmount());
        expenseTrackingDto.setCreatedDate(expenseTracking.getCreatedDate());
        expenseTrackingDto.setCategoryId(expenseTracking.getCategoryId());
        expenseTrackingDto.setUrl(expenseTracking.getUrl());
        expenseTrackingDto.setComments(expenseTracking.getComments());

        return expenseTrackingDto;
    }

    public static void updateEntity(ExpenseTrackingDto expenseTrackingDto, ExpenseTracking expenseTracking){
        expenseTracking.setAmount(expenseTrackingDto.getAmount());
        expenseTracking.setCreatedDate(expenseTrackingDto.getCreatedDate());
        expenseTracking.setCategoryId(expenseTrackingDto.getCategoryId());
        expenseTracking.setUrl(expenseTrackingDto.getUrl());
        expenseTracking.setComments(expenseTrackingDto.getComments());
    }
}
