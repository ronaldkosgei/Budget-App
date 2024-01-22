package com.budget_app.controller;

import com.budget_app.dto.FeedBackDto;
import com.budget_app.service.FeedBackService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    private final FeedBackService feedBackService;

    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @PostMapping("/save")
    public FeedBackDto saveFeedBack(@RequestBody FeedBackDto feedBackDto) {
        return feedBackService.saveFeedBack(feedBackDto);
    }

    @GetMapping("/get/{feedBackId}")
    public Optional<FeedBackDto> getFeedBackById(@PathVariable Long feedBackId) {
        return feedBackService.getFeedBackById(feedBackId);
    }

    @GetMapping("/get/all")
    public Iterable<FeedBackDto> getAllFeedBacks() {
        return feedBackService.getAllFeedBacks();
    }

    @PutMapping("/update/{feedBackId}")
    public Optional<FeedBackDto> updateFeedBack(@PathVariable Long feedBackId, @RequestBody FeedBackDto feedBackDto) {
        return feedBackService.updateFeedBack(feedBackId, feedBackDto);
    }

    @DeleteMapping("/delete/{feedBackId}")
    public void deleteFeedBackById(@PathVariable Long feedBackId) {
        feedBackService.deleteFeedBackById(feedBackId);
    }

}
