package com.nqdtotty.vehiclebooking.service;

import com.nqdtotty.vehiclebooking.model.request.UserChangePasswordRequest;
import com.nqdtotty.vehiclebooking.model.request.UserLoginRequest;
import com.nqdtotty.vehiclebooking.model.request.UserRegisterRequest;
import com.nqdtotty.vehiclebooking.model.request.UserUpdateRequest;
import com.nqdtotty.vehiclebooking.model.response.CommonResponse;
import com.nqdtotty.vehiclebooking.model.response.UserResponse;

import java.util.List;

public interface UserService {
    public CommonResponse loginUser(UserLoginRequest userLoginRequest);

    public CommonResponse registerUser(UserRegisterRequest userRegisterRequest);

    public List<UserResponse> getAllUser();

    public CommonResponse updateUser(UserUpdateRequest userUpdateRequest);

    CommonResponse deleteUser(String phoneNumber);

    List<UserResponse> searchByPhoneNumber(String keySearch);

    CommonResponse createAdmin(UserRegisterRequest request);

    CommonResponse changePassword(UserChangePasswordRequest request);
}
