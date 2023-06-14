package com.nqdtotty.vehiclebooking.service;

import com.nqdtotty.vehiclebooking.model.request.UserChangePasswordRequest;
import com.nqdtotty.vehiclebooking.model.request.UserLoginRequest;
import com.nqdtotty.vehiclebooking.model.request.UserRegisterRequest;
import com.nqdtotty.vehiclebooking.model.request.UserUpdateRequest;
import com.nqdtotty.vehiclebooking.model.response.CommonResponse;

public interface UserService {
    public CommonResponse loginUser(UserLoginRequest userLoginRequest);

    public CommonResponse registerUser(UserRegisterRequest userRegisterRequest);

    public CommonResponse getAllUser();

    public CommonResponse updateUser(UserUpdateRequest userUpdateRequest, String userId);

    public CommonResponse deleteUser(String phoneNumber);

    public CommonResponse createAdmin(UserRegisterRequest request);

    public CommonResponse changePassword(UserChangePasswordRequest request);
}
