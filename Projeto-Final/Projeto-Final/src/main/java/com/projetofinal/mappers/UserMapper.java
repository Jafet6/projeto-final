package com.projetofinal.mappers;

import com.projetofinal.domains.User;
import com.projetofinal.requests.UserRegisterRequest;
import com.projetofinal.responses.UserDataResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

public class UserMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public UserDataResponse convertUserDomainToUserResponse( User user){
        UserDataResponse userDataResponse = modelMapper.map(user, UserDataResponse.class);
        return userDataResponse;
    }

    public User convertUserRegisterRequestToEntity(UserRegisterRequest userRequest) throws ParseException{
        User userModel = modelMapper.map(userRequest, User.class);
        return userModel;
    }

    public UserDataResponse convertUserModelToUserResponse(User user) {
        UserDataResponse userDataResponse = modelMapper.map(user, UserDataResponse.class);
        return userDataResponse;
    }
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
