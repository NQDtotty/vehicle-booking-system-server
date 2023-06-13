package com.nqdtotty.vehiclebooking.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {
    private  String userId;
    private  String fullname;
    private  String gender;
    private  String phoneNumber;
    private  String email;
    private  String role;
    private  String status;
}
