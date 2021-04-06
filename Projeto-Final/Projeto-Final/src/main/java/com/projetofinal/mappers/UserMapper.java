package com.projetofinal.mappers;

import com.projetofinal.domains.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

//    public UserDataResponse convertUserModelToUserResponse(User user) {
//        UserDataResponse userDataResponse = modelMapper.map(user, UserDataResponse.class);
//        return userDataResponse;
//    }
//
//    public User convertUserRegisterRequestToEntity(UserRegisterRequest userRequest) throws ParseException {
//        User userModel = modelMapper.map(userRequest, User.class);
//        return userModel;
//    }
//
//    public User convertUserLoginRequestToEntity(UserLoginRequest userRequest) throws ParseException {
//        User userModel = modelMapper.map(userRequest, User.class);
//        return userModel;
//    }
}
