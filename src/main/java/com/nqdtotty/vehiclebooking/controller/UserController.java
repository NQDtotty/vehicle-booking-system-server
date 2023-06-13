package com.nqdtotty.vehiclebooking.controller;

import com.nqdtotty.vehiclebooking.common.CommonClass;
import com.nqdtotty.vehiclebooking.model.request.UserLoginRequest;
import com.nqdtotty.vehiclebooking.model.request.UserRegisterRequest;
import com.nqdtotty.vehiclebooking.model.request.UserUpdateRequest;
import com.nqdtotty.vehiclebooking.model.response.CommonResponse;
import com.nqdtotty.vehiclebooking.model.response.UserResponse;
import com.nqdtotty.vehiclebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
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
                    userRegisterRequest.getEmail().isEmpty() || userRegisterRequest.getFullname().isEmpty() ||
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
            List<UserResponse> responseList = userService.getAllUser();
            if (responseList != null){
                responseEntity =  ResponseEntity.status(200).body(responseList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return responseEntity;
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        ResponseEntity responseEntity = null;
        try {
            CommonResponse commonResponse = userService.updateUser(userUpdateRequest);
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
}
