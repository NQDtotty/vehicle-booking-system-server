package com.nqdtotty.vehiclebooking.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponse {
    private String feedbackId;
    private String userId;
    private String message;
    private String response;
    private String status;
}
