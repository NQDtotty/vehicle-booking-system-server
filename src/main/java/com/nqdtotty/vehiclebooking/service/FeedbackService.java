package com.nqdtotty.vehiclebooking.service;

import com.nqdtotty.vehiclebooking.model.request.FeedbackCreateRequest;
import com.nqdtotty.vehiclebooking.model.request.FeedbackResponseRequest;
import com.nqdtotty.vehiclebooking.model.response.CommonResponse;

public interface FeedbackService {
    public CommonResponse getAllFeedback();

    public CommonResponse createFeedback(FeedbackCreateRequest feedbackCreateRequest);

    public CommonResponse responseFeedback(FeedbackResponseRequest feedbackResponseRequest, String feedbackId);

    public CommonResponse deleteFeedback(String feedbackId);
}
