package com.budget_app.mapper;

import com.budget_app.dto.FeedBackDto;
import com.budget_app.entity.FeedBack;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class FeedBackMapper {

    public static FeedBack toEntity(FeedBackDto feedBackDto){
        FeedBack feedBack = new FeedBack();
        feedBack.setFeedBackId(feedBackDto.getFeedBackId());
        feedBack.setUserId(feedBackDto.getUserId());
        feedBack.setSendDate(feedBackDto.getSendDate());
        feedBack.setFeedBackType(feedBackDto.getFeedBackType());
        feedBack.setFeedBackText(feedBackDto.getFeedBackText());
        feedBack.setStatus(feedBackDto.getStatus());
        feedBack.setResponseStatus(feedBackDto.getResponseStatus());
        feedBack.setAttachmentUrl(feedBackDto.getAttachmentUrl());

        return feedBack;
    }

    public static FeedBackDto toDto(FeedBack feedBack){
        FeedBackDto feedBackDto = new FeedBackDto();
        feedBackDto.setFeedBackId(feedBack.getFeedBackId());
        feedBackDto.setUserId(feedBack.getUserId());
        feedBackDto.setSendDate(feedBack.getSendDate());
        feedBackDto.setFeedBackType(feedBack.getFeedBackType());
        feedBackDto.setFeedBackText(feedBack.getFeedBackText());
        feedBackDto.setStatus(feedBack.getStatus());
        feedBackDto.setResponseStatus(feedBack.getResponseStatus());
        feedBackDto.setAttachmentUrl(feedBack.getAttachmentUrl());

        return feedBackDto;
    }

    public static void updateEntity(FeedBack feedBack, FeedBackDto feedBackDto){
        feedBack.setUserId(feedBackDto.getUserId());
        feedBack.setSendDate(feedBackDto.getSendDate());
        feedBack.setFeedBackType(feedBackDto.getFeedBackType());
        feedBack.setFeedBackText(feedBackDto.getFeedBackText());
        feedBack.setStatus(feedBackDto.getStatus());
        feedBack.setResponseStatus(feedBackDto.getResponseStatus());
        feedBack.setAttachmentUrl(feedBackDto.getAttachmentUrl());
    }
}
