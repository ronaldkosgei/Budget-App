package com.budget_app.service;

import com.budget_app.dto.FeedBackDto;


import java.util.List;
import java.util.Optional;

public interface FeedBackService {

    FeedBackDto saveFeedBack(FeedBackDto feedBackDto);

    Optional<FeedBackDto> getFeedBackById(Long feedBackId);

    List<FeedBackDto> getAllFeedBacks();

    Optional<FeedBackDto> updateFeedBack(Long feedBckId, FeedBackDto feedBackDto);

    Optional<Object> deleteFeedBackById(Long feedBackId);
}
