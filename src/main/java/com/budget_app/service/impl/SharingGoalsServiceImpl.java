package com.budget_app.service.impl;


import com.budget_app.dto.SharingGoalsDto;
import com.budget_app.entity.SharingGoals;
import com.budget_app.mapper.SharingGoalsMapper;
import com.budget_app.repository.SharingGoalsRepository;
import com.budget_app.service.SharingGoalsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SharingGoalsServiceImpl implements SharingGoalsService {

    private final SharingGoalsRepository sharingGoalsRepository;

    private final SharingGoalsMapper sharingGoalsMapper;

    public SharingGoalsServiceImpl(SharingGoalsRepository sharingGoalsRepository, SharingGoalsMapper sharingGoalsMapper) {
        this.sharingGoalsRepository = sharingGoalsRepository;
        this.sharingGoalsMapper = sharingGoalsMapper;
    }

    @Override
    public SharingGoalsDto saveGoal(SharingGoalsDto sharingGoalsDto) {
        SharingGoals sharingGoals = sharingGoalsMapper.toEntity(sharingGoalsDto);
        sharingGoals = sharingGoalsRepository.save(sharingGoals);
        return sharingGoalsMapper.toDto(sharingGoals);
    }

    @Override
    public Optional<SharingGoalsDto> getGoal(Long goalId) {
        try {
            Optional<SharingGoals> sharingGoals = sharingGoalsRepository.findById(goalId);
            if (sharingGoals.isPresent()) {
                SharingGoalsDto sharingGoalsDto = sharingGoalsMapper.toDto(sharingGoals.get());
                return Optional.of(sharingGoalsDto);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<SharingGoalsDto> getAllGoals() {
        List<SharingGoals> sharingGoals = sharingGoalsRepository.findAll();
        return sharingGoals.stream()
                .map(SharingGoalsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SharingGoalsDto> updateGoal(Long goalId, SharingGoalsDto sharingGoalsDto) {
        try {
            Optional<SharingGoals> sharingGoalsOptional = sharingGoalsRepository.findById(goalId);
            if (sharingGoalsOptional.isPresent()){
                SharingGoals existingSharingGoals = sharingGoalsOptional.get();
                SharingGoals updatedSharingGoals = sharingGoalsRepository.save(existingSharingGoals);
                return Optional.of(sharingGoalsMapper.toDto(updatedSharingGoals));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<SharingGoalsDto> deleteGoal(Long goalId) {
        try {
            Optional<SharingGoals> sharingGoalsOptional = sharingGoalsRepository.findById(goalId);
            if (sharingGoalsOptional.isPresent()){
                SharingGoals existingSharingGoals = sharingGoalsOptional.get();
                sharingGoalsRepository.delete(existingSharingGoals);
                return Optional.of(sharingGoalsMapper.toDto(existingSharingGoals));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
