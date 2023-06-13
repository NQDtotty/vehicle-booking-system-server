package com.nqdtotty.vehiclebooking.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {
    private final String phoneNumber;
    private final String password;
}
