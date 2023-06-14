package com.nqdtotty.vehiclebooking.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class FeedbackCreateRequest implements Serializable {
    private final String userId;
    private final String message;
}
