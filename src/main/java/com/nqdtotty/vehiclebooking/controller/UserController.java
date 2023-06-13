package com.nqdtotty.vehiclebooking.controller;

import com.nqdtotty.vehiclebooking.common.CommonClass;
import com.nqdtotty.vehiclebooking.model.request.UserChangePasswordRequest;
import com.nqdtotty.vehiclebooking.model.request.UserLoginRequest;
import com.nqdtotty.vehiclebooking.model.request.UserRegisterRequest;
import com.nqdtotty.vehiclebooking.model.request.UserUpdateRequest;
import com.nqdtotty.vehiclebooking.model.response.CommonResponse;
import com.nqdtotty.vehiclebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
        ResponseEntity responseEntity = null;
        try{
            if (userLoginRequest.getPhoneNumber().isEmpty() || userLoginRequest.getPassword().isEmpty()){
                responseEntity = ResponseEntity.status(417).body(CommonClass.notEmpty());
            }else {
                CommonResponse commonResponse = userService.loginUser(userLoginRequest);
                if (commonResponse.getStatus() == 200){
                    responseEntity = ResponseEntity.status(200).body(commonResponse);
                } else if (commonResponse.getStatus() == 417) {
                    responseEntity = ResponseEntity.status(417).body(commonResponse);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return responseEntity;
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        ResponseEntity responseEntity = null;
        try{
            if (userRegisterRequest.getPhoneNumber().isEmpty() || userRegisterRequest.getPassword().isEmpty() ||
                    userRegisterRequest.getEmail().isEmpty() || userRegisterRequest.getFullName().isEmpty() ||
                    userRegisterRequest.getGender().isEmpty()){
                responseEntity = ResponseEntity.status(417).body(CommonClass.notEmpty());
            }else {
                CommonResponse commonResponse = userService.registerUser(userRegisterRequest);
                if (commonResponse.getStatus() == 200){
                    responseEntity =  ResponseEntity.status(200).body(commonResponse);
                } else if (commonResponse.getStatus() == 417) {
                    responseEntity = ResponseEntity.status(417).body(commonResponse);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return responseEntity;
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser() {
        ResponseEntity responseEntity = null;
        try{
            CommonResponse commonResponse = userService.getAllUser();
            if (commonResponse.getStatus() == 200){
                responseEntity =  ResponseEntity.status(200).body(commonResponse);
            } else if(commonResponse.getStatus() == 417) {
                responseEntity = ResponseEntity.status(417).body(commonResponse);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return responseEntity;
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest userUpdateRequest, @PathVariable("userId") String userId) {
        ResponseEntity responseEntity = null;
        try {
            CommonResponse commonResponse = userService.updateUser(userUpdateRequest, userId);
            if (commonResponse.getStatus() == 200){
                responseEntity =  ResponseEntity.status(200).body(commonResponse);
            }else if(commonResponse.getStatus() == 417) {
                responseEntity =  ResponseEntity.status(417).body(commonResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseEntity;
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam String phoneNumber) {
        ResponseEntity responseEntity = null;
        try {
            CommonResponse commonResponse = userService.deleteUser(phoneNumber);
            if (commonResponse.getStatus() == 200) {
                responseEntity = ResponseEntity.status(200).body(commonResponse);
            } else if (commonResponse.getStatus() == 417) {
                responseEntity = ResponseEntity.status(417).body(commonResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseEntity;
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody UserChangePasswordRequest userChangePasswordRequest) {
        ResponseEntity responseEntity = null;
        try {
            CommonResponse commonResponse = userService.changePassword(userChangePasswordRequest);
            if (commonResponse.getStatus() == 200) {
                responseEntity = ResponseEntity.status(200).body(commonResponse);
            } else if (commonResponse.getStatus() == 417) {
                responseEntity = ResponseEntity.status(417).body(commonResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseEntity;
        }
    }
}
