package com.budget_app.service.impl;

import com.budget_app.dto.IncomeTrackingDto;
import com.budget_app.entity.IncomeTracking;
import com.budget_app.mapper.IncomeTrackingMapper;
import com.budget_app.repository.IncomeTrackingRepository;
import com.budget_app.service.IncomeTrackingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncomeTrackingServiceImpl implements IncomeTrackingService {

    private final IncomeTrackingRepository incomeTrackingRepository;

    private final IncomeTrackingMapper incomeTrackingMapper;

    public IncomeTrackingServiceImpl(IncomeTrackingRepository incomeTrackingRepository, IncomeTrackingMapper incomeTrackingMapper) {
        this.incomeTrackingRepository = incomeTrackingRepository;
        this.incomeTrackingMapper = incomeTrackingMapper;
    }

    @Override
    public IncomeTrackingDto saveIncome(IncomeTrackingDto incomeTrackingDto) {
        IncomeTracking incomeTracking = incomeTrackingMapper.toEntity(incomeTrackingDto);
        incomeTracking = incomeTrackingRepository.save(incomeTracking);
        return incomeTrackingMapper.toDto(incomeTracking);
    }

    @Override
    public Optional<IncomeTrackingDto> getIncomeById(Long incomeId) {
        try {
            Optional<IncomeTracking> incomeTrackingOptional = incomeTrackingRepository.findById(incomeId);

            if (incomeTrackingOptional.isPresent()) {
                IncomeTracking existingIncomeTracking = incomeTrackingOptional.get();
                IncomeTracking updatedIncomeTracking = incomeTrackingRepository.save(existingIncomeTracking);
                return Optional.of(incomeTrackingMapper.toDto(updatedIncomeTracking));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<IncomeTrackingDto> getAllIncomeTrackings() {
        List<IncomeTracking> allIncomeTrackings = incomeTrackingRepository.findAll();
        return allIncomeTrackings.stream()
                .map(IncomeTrackingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<IncomeTrackingDto> updateIncomeTracking(Long incomeId, IncomeTrackingDto incomeTrackingDto) {
        try {
            Optional<IncomeTracking> IncomeTrackingOptional = incomeTrackingRepository.findById(incomeId);
            if (IncomeTrackingOptional.isPresent()) {
                IncomeTracking existingIncomeTracking = IncomeTrackingOptional.get();
                IncomeTracking updatedIncomeTracking = incomeTrackingRepository.save(existingIncomeTracking);
                return Optional.of(incomeTrackingMapper.toDto(updatedIncomeTracking));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Object> deleteIncomeTracking(Long incomeId) {
        try {
            incomeTrackingRepository.deleteById(incomeId);
            return Optional.of("Income Tracking deleted successfully");
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
