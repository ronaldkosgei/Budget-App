package com.budget_app.service.impl;

import com.budget_app.dto.MonetaryGoalsDto;
import com.budget_app.entity.FeedBack;
import com.budget_app.entity.MonetaryGoals;
import com.budget_app.mapper.MonetaryGoalsMapper;
import com.budget_app.repository.MonetaryGoalsRepository;
import com.budget_app.service.MonetaryGoalsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MonetaryGoalsServiceImpl implements MonetaryGoalsService {

    private final MonetaryGoalsRepository monetaryGoalsRepository;

    private final MonetaryGoalsMapper monetaryGoalsMapper;

    public MonetaryGoalsServiceImpl(MonetaryGoalsRepository monetaryGoalsRepository, MonetaryGoalsMapper monetaryGoalsMapper){
        this.monetaryGoalsRepository = monetaryGoalsRepository;
        this.monetaryGoalsMapper = monetaryGoalsMapper;
    }

    @Override
    public MonetaryGoalsDto createMonetaryGoals(MonetaryGoalsDto monetaryGoalsDto) {
        MonetaryGoals monetaryGoals = monetaryGoalsMapper.toEntity(monetaryGoalsDto);
        monetaryGoals = monetaryGoalsRepository.save(monetaryGoals);
        return monetaryGoalsMapper.toDto(monetaryGoals);
    }

    @Override
    public Optional<MonetaryGoalsDto> getMonetaryGoalsById(Long goalId) {
        try {
            Optional<MonetaryGoals> monetaryGoals = monetaryGoalsRepository.findById(goalId);
            if (monetaryGoals.isPresent()) {
                return Optional.of(monetaryGoalsMapper.toDto(monetaryGoals.get()));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<MonetaryGoalsDto> getAllMonetaryGoals() {
        List<MonetaryGoals> allMonetaryGoals = monetaryGoalsRepository.findAll();
        return allMonetaryGoals.stream()
                .map(MonetaryGoalsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MonetaryGoalsDto> updateMonetaryGoals(Long goalId, MonetaryGoalsDto monetaryGoalsDto) {
        try {
            Optional<MonetaryGoals> monetaryGoalsOptional = monetaryGoalsRepository.findById(goalId);
            if (monetaryGoalsOptional.isPresent()) {
                MonetaryGoals existingMonetaryGoals = monetaryGoalsOptional.get();
                MonetaryGoals updatedMonetaryGoals = monetaryGoalsRepository.save(existingMonetaryGoals);
                return Optional.of(monetaryGoalsMapper.toDto(updatedMonetaryGoals));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<MonetaryGoalsDto> deleteMonetaryGoalsById(Long goalId) {
        try {
            Optional<MonetaryGoals> monetaryGoalsOptional = monetaryGoalsRepository.findById(goalId);
            if (monetaryGoalsOptional.isPresent()) {
                MonetaryGoals existingMonetaryGoals = monetaryGoalsOptional.get();
                monetaryGoalsRepository.delete(existingMonetaryGoals);
                return Optional.of(monetaryGoalsMapper.toDto(existingMonetaryGoals));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
