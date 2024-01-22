package com.budget_app.service.impl;

import com.budget_app.dto.ExpenseTrackingDto;
import com.budget_app.dto.FeedBackDto;
import com.budget_app.entity.ExpenseTracking;
import com.budget_app.entity.FeedBack;
import com.budget_app.mapper.FeedBackMapper;
import com.budget_app.repository.FeedBackRepository;
import com.budget_app.service.FeedBackService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    private final FeedBackRepository feedBackRepository;

    private final FeedBackMapper feedBackMapper;

    public FeedBackServiceImpl(FeedBackRepository feedBackRepository, FeedBackMapper feedBackMapper) {
        this.feedBackRepository = feedBackRepository;
        this.feedBackMapper = feedBackMapper;
    }

    @Override
    public FeedBackDto saveFeedBack(FeedBackDto feedBackDto) {
        FeedBack feedBack = feedBackMapper.toEntity(feedBackDto);
        FeedBack savedFeedBack = feedBackRepository.save(feedBack);
        return feedBackMapper.toDto(savedFeedBack);
    }

    @Override
    public Optional<FeedBackDto> getFeedBackById(Long feedBackId) {
        try {
            Optional<FeedBack> feedBackOptional = feedBackRepository.findById(feedBackId);

            if (feedBackOptional.isPresent()) {
                FeedBack existingFeedBack = feedBackOptional.get();
                FeedBack updatedFeedBack = feedBackRepository.save(existingFeedBack);
                return Optional.of(feedBackMapper.toDto(updatedFeedBack));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<FeedBackDto> getAllFeedBacks() {
        List<FeedBack> allFeedBacks = feedBackRepository.findAll();
        return allFeedBacks.stream()
                .map(FeedBackMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FeedBackDto> updateFeedBack(Long feedBckId, FeedBackDto feedBackDto) {
        try {
            Optional<FeedBack> feedBackOptional = feedBackRepository.findById(feedBckId);

            if (feedBackOptional.isPresent()) {
                FeedBack existingFeedBack = feedBackOptional.get();
                feedBackMapper.updateEntity(existingFeedBack, feedBackDto);
                FeedBack updatedFeedBack = feedBackRepository.save(existingFeedBack);
                return Optional.of(feedBackMapper.toDto(updatedFeedBack));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Object> deleteFeedBackById(Long feedBackId) {
        try {
            Optional<FeedBack> feedBackOptional = feedBackRepository.findById(feedBackId);

            if (feedBackOptional.isPresent()) {
                FeedBack existingFeedBack = feedBackOptional.get();
                feedBackRepository.delete(existingFeedBack);
                return Optional.of(existingFeedBack);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
