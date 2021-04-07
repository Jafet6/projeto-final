package com.projetofinal.controllers;

import com.projetofinal.domains.User;
import com.projetofinal.mappers.UserMapper;
import com.projetofinal.repository.UserRepository;
import com.projetofinal.requests.UserRegisterRequest;
import com.projetofinal.responses.UserDataResponse;
import com.projetofinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private boolean checkRegister(String cpf, String login) throws Exception {
        if (userRepository.existsByCpfOrLogin(cpf,login)) {
            throw new Exception("CPF ou Login já cadastrado");
        }
        return  true;
    }


    @PostMapping
    private ResponseEntity<Object> create(@Valid @RequestBody UserRegisterRequest userRequest) throws Exception {
        User userDomain = userMapper.convertUserRegisterRequestToEntity(userRequest);
        System.out.println(userRequest);
        UserDataResponse serviceResponse = userService.create(userDomain);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceResponse);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    private User updateById(@PathVariable("id") Long id, @Valid @RequestBody User user) throws Exception {
        user.setId(id);
        checkRegister(user.getCpf(), user.getLogin());
        return userRepository.save(user);
    }

    @GetMapping
    private List<User> findAll() {
        return userRepository.findAll();
    }
}
