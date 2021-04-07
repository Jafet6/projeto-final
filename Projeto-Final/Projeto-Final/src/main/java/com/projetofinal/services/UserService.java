package com.projetofinal.services;

import com.projetofinal.domains.User;
import com.projetofinal.mappers.UserMapper;
import com.projetofinal.repository.UserRepository;
import com.projetofinal.responses.UserDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDataResponse create(User user) throws Exception {
       userRepository.save(user);
        UserDataResponse userResponse = userMapper.convertUserDomainToUserResponse(user);
         return userResponse;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    private User updateById(Long id, User user) throws Exception {
        user.setId(id);
        userRepository.save(user);
        return user;
    }

    private List<User> findAll() {

        return userRepository.findAll();
    }
}
