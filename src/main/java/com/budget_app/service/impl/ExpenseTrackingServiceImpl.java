package com.budget_app.service.impl;

import com.budget_app.dto.ExpenseTrackingDto;
import com.budget_app.entity.ExpenseTracking;
import com.budget_app.mapper.ExpenseTrackingMapper;
import com.budget_app.repository.ExpenseTrackingRepository;
import com.budget_app.service.ExpenseTrackingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseTrackingServiceImpl implements ExpenseTrackingService {

    private final ExpenseTrackingRepository expenseTrackingRepository;

    private final ExpenseTrackingMapper expenseTrackingMapper;

    public ExpenseTrackingServiceImpl(ExpenseTrackingRepository expenseTrackingRepository, ExpenseTrackingMapper expenseTrackingMapper) {
        this.expenseTrackingRepository = expenseTrackingRepository;
        this.expenseTrackingMapper = expenseTrackingMapper;
    }

    @Override
    public ExpenseTrackingDto saveExpenseTracking(ExpenseTrackingDto expenseTrackingDto) {
        ExpenseTracking expenseTracking = expenseTrackingMapper.toEntity(expenseTrackingDto);
        ExpenseTracking savedExpenseTracking = expenseTrackingRepository.save(expenseTracking);
        return expenseTrackingMapper.toDto(savedExpenseTracking);
    }

    @Override
    public Optional<ExpenseTrackingDto> getExpenseTrackingById(Long expenseId) {
        Optional<ExpenseTracking> expenseTracking = expenseTrackingRepository.findById(expenseId);
        return expenseTracking.map(ExpenseTrackingMapper::toDto);
    }

    @Override
    public List<ExpenseTrackingDto> getAllExpenseTrackings() {
        List<ExpenseTracking> allExpenseTrackings = expenseTrackingRepository.findAll();
        return allExpenseTrackings.stream()
                .map(ExpenseTrackingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ExpenseTrackingDto> updateExpenseTracking(Long expenseId, ExpenseTrackingDto expenseTrackingDto) {
        try {
            Optional<ExpenseTracking> expenseTrackingOptional = expenseTrackingRepository.findById(expenseId);

            if (expenseTrackingOptional.isPresent()) {
                ExpenseTracking existingExpenseTracking = expenseTrackingOptional.get();
                expenseTrackingMapper.updateEntity(expenseTrackingDto, existingExpenseTracking);
                ExpenseTracking updatedExpenseTracking = expenseTrackingRepository.save(existingExpenseTracking);
                return Optional.of(expenseTrackingMapper.toDto(updatedExpenseTracking));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Object> deleteExpenseTracking(Long expenseId) {
        try {
            Optional<ExpenseTracking> expenseTrackingOptional = expenseTrackingRepository.findById(expenseId);

            if (expenseTrackingOptional.isPresent()) {
                ExpenseTracking existingExpenseTracking = expenseTrackingOptional.get();
                expenseTrackingRepository.delete(existingExpenseTracking);
                return Optional.of(existingExpenseTracking);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
