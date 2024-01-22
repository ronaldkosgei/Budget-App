package com.budget_app.service.impl;

import com.budget_app.dto.BudgetManagementDto;
import com.budget_app.entity.BudgetManagement;
import com.budget_app.mapper.BudgetManagementMapper;
import com.budget_app.repository.BudgetManagementRepository;
import com.budget_app.service.BudgetManagementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BudgetManagementServiceImpl implements BudgetManagementService {

    private final BudgetManagementRepository budgetManagementRepository;

    private final BudgetManagementMapper budgetManagementMapper;

    public BudgetManagementServiceImpl(BudgetManagementRepository budgetManagementRepository,
                                       BudgetManagementMapper budgetManagementMapper) {
        this.budgetManagementRepository = budgetManagementRepository;
        this.budgetManagementMapper = budgetManagementMapper;
    }

    @Override
    public BudgetManagementDto saveBudgetManagement(BudgetManagementDto budgetManagementDto) {
        BudgetManagement budgetManagement = budgetManagementMapper.toEntity(budgetManagementDto);
        BudgetManagement savedBudgetManagement = budgetManagementRepository.save(budgetManagement);
        return budgetManagementMapper.toDto(savedBudgetManagement);
    }

    @Override
    public Optional<BudgetManagementDto> getBudgetManagementById(Long budgetManagementId) {
        Optional<BudgetManagement> budgetManagement = budgetManagementRepository.findById(budgetManagementId);
        return budgetManagement.map(BudgetManagementMapper::toDto);
    }

    @Override
    public List<BudgetManagementDto> getAllBudgetManagements() {
        List<BudgetManagement> allBudgetManagements = budgetManagementRepository.findAll();
        return allBudgetManagements.stream()
                .map(BudgetManagementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BudgetManagementDto> updateBudgetManagement(Long budgetManagementId, BudgetManagementDto budgetManagementDto) {
        try {
            Optional<BudgetManagement> budgetManagementOptional = budgetManagementRepository.findById(budgetManagementId);

            if (budgetManagementOptional.isPresent()) {
                BudgetManagement existingBudgetManagement = budgetManagementOptional.get();
                budgetManagementMapper.updateEntity(budgetManagementDto, existingBudgetManagement);
                BudgetManagement updatedBudgetManagement = budgetManagementRepository.save(existingBudgetManagement);
                return Optional.of(budgetManagementMapper.toDto(updatedBudgetManagement));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Object> deleteBudgetManagement(Long budgetManagementId) {
        try {
            Optional<BudgetManagement> budgetManagementOptional = budgetManagementRepository.findById(budgetManagementId);

            if (budgetManagementOptional.isPresent()) {
                BudgetManagement existingBudgetManagement = budgetManagementOptional.get();
                budgetManagementRepository.delete(existingBudgetManagement);
                return Optional.of(existingBudgetManagement);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
