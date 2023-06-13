package com.nqdtotty.vehiclebooking.service.impl;

import com.nqdtotty.vehiclebooking.common.CommonClass;
import com.nqdtotty.vehiclebooking.entity.User;
import com.nqdtotty.vehiclebooking.model.request.UserChangePasswordRequest;
import com.nqdtotty.vehiclebooking.model.request.UserLoginRequest;
import com.nqdtotty.vehiclebooking.model.request.UserRegisterRequest;
import com.nqdtotty.vehiclebooking.model.request.UserUpdateRequest;
import com.nqdtotty.vehiclebooking.model.response.CommonResponse;
import com.nqdtotty.vehiclebooking.model.response.UserResponse;
import com.nqdtotty.vehiclebooking.repository.UserRepository;
import com.nqdtotty.vehiclebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public CommonResponse loginUser(UserLoginRequest userLoginRequest) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            User user = userRepository.findByPhoneNumber(userLoginRequest.getPhoneNumber().trim());
            // This pass is encrypted by MD5 algorithms
            String passwordEncrypt = CommonClass.getMD5(userLoginRequest.getPassword().trim());
            if(user == null) {
                commonResponse.setStatus(417);
                commonResponse.setMessage("Account does not exist");
            } else {
                if (passwordEncrypt.equals(user.getPassword().trim()) && user.getStatus().equals("active")){
                    commonResponse.setStatus(200);
                    commonResponse.setMessage("Login successfully");
                    UserResponse loginResponse = new UserResponse();
                    loginResponse.setUserId(user.getUserId());
                    loginResponse.setPhoneNumber(user.getPhoneNumber());
                    loginResponse.setFullname(user.getFullname());
                    loginResponse.setEmail(user.getEmail());
                    loginResponse.setGender(user.getGender());
                    loginResponse.setRole(user.getRole());
                    commonResponse.setData(loginResponse);
                } else if (passwordEncrypt.equals(user.getPassword().trim()) && user.getStatus().equals("locked")) {
                    commonResponse.setStatus(417);
                    commonResponse.setMessage("Account is locked");
                } else if (passwordEncrypt.equals(user.getPassword().trim()) && user.getStatus().equals("inactive")) {
                    commonResponse.setStatus(417);
                    commonResponse.setMessage("Account is inactive");
                } else if (!passwordEncrypt.equals(user.getPassword().trim())) {
                    commonResponse.setStatus(417);
                    commonResponse.setMessage("Wrong password");
                }
            }
        } catch (Exception e) {
            commonResponse.setStatus(417);
            commonResponse.setMessage("Fail to login");
            e.printStackTrace();
        } finally {
            return commonResponse;
        }
    }

    @Override
    public CommonResponse registerUser(UserRegisterRequest userRegisterRequest) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            User checkExist = userRepository.findByPhoneNumber(userRegisterRequest.getPhoneNumber().trim());
            if(checkExist == null) {
                User user = new User();
                Random random = new Random();
                String userId = "user" + userRegisterRequest.getPhoneNumber().substring(5)
                        .concat(Integer.toString(random.nextInt(99)));
                user.setUserId(userId);
                user.setPhoneNumber(userRegisterRequest.getPhoneNumber());
                user.setPassword(CommonClass.getMD5(userRegisterRequest.getPassword().trim()));
                user.setEmail(userRegisterRequest.getEmail());
                user.setFullname(userRegisterRequest.getFullname());
                user.setGender(userRegisterRequest.getGender());
                user.setRole("user");
                user.setStatus("inactive");

                userRepository.save(user);
                commonResponse.setStatus(200);
                commonResponse.setMessage("Register successfully");
            } else {
                commonResponse.setStatus(417);
                commonResponse.setMessage("Account is existed");
            }
        } catch (Exception e) {
            commonResponse.setStatus(417);
            commonResponse.setMessage("Fail to register");
            e.printStackTrace();
        } finally {
            return commonResponse;
        }

    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> userList = userRepository.findAll();
        if (userList != null){
            List<UserResponse> responseList = new ArrayList<>();
            for (int i = 0; i < userList.size(); i++){
                UserResponse userResponse = new UserResponse();
                userResponse.setUserId(userList.get(i).getUserId());
                userResponse.setPhoneNumber(userList.get(i).getPhoneNumber());
                userResponse.setFullname(userList.get(i).getFullname());
                userResponse.setEmail(userList.get(i).getEmail());
                userResponse.setRole(userList.get(i).getRole());
                userResponse.setGender(userList.get(i).getGender());
                userResponse.setStatus(userList.get(i).getStatus());
                responseList.add(userResponse);
            }
            return responseList;
        }else {
            return null;
        }
    }

    @Override
    public CommonResponse updateUser(UserUpdateRequest userUpdateRequest) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            User user = userRepository.findByPhoneNumber(userUpdateRequest.getPhoneNumber().trim());
            if(user == null) {
                commonResponse.setStatus(417);
                commonResponse.setMessage("Account is not exist");
            } else {
                user.setFullname(userUpdateRequest.getFullname());
                user.setEmail(userUpdateRequest.getEmail());
                user.setGender(userUpdateRequest.getGender());
                user.setStatus(userUpdateRequest.getStatus());
                userRepository.save(user);
                commonResponse.setStatus(200);
                commonResponse.setMessage("Update successfully");
                commonResponse.setData(user);
            }
        } catch (Exception e) {
            commonResponse.setStatus(417);
            commonResponse.setMessage("Fail to update");
            e.printStackTrace();
        } finally {
            return commonResponse;
        }
    }

    @Override
    public CommonResponse deleteUser(String phoneNumber) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            User user = userRepository.findByPhoneNumber(phoneNumber);
            if (user != null){
                userRepository.delete(user);
                commonResponse.setStatus(200);
                commonResponse.setMessage("Delete successfully");
            }else {
                commonResponse.setStatus(417);
                commonResponse.setMessage("Không tồn tại user để xóa !!!");
            }
        } catch (Exception e) {
            commonResponse.setStatus(417);
            commonResponse.setMessage("Fail to delete");
            e.printStackTrace();
        } finally {
            return commonResponse;
        }
    }

    @Override
    public List<UserResponse> searchByPhoneNumber(String keySearch) {
        return null;
    }

    @Override
    public CommonResponse createAdmin(UserRegisterRequest request) {
        return null;
    }

    @Override
    public CommonResponse changePassword(UserChangePasswordRequest request) {
        return null;
    }
}
