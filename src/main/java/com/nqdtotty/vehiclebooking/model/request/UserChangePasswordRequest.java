package com.nqdtotty.vehiclebooking.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserChangePasswordRequest implements Serializable {
    private final String phoneNumber;
    private final String oldPassword;
    private final String newPassword;
}
