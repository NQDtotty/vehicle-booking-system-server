package com.nqdtotty.vehiclebooking.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdateRequest implements Serializable {
    private final String phoneNumber;
    private final String fullName;
    private final String gender;
    private final String email;
    private final String status;
}
