package com.projetofinal.controllers;

import com.projetofinal.domains.User;
import com.projetofinal.mappers.UserMapper;
import com.projetofinal.repository.UserRepository;
import com.projetofinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/users")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    private boolean checkRegister(String cpf, String login) throws Exception {
        if (userRepository.existsByCpfOrLogin(cpf,login)) {
            throw new Exception("CPF ou Login já cadastrado");
        }
        return  true;
    }


    @PostMapping
    private User create(@Valid @RequestBody User user) throws Exception {
        checkRegister(user.getCpf(), user.getLogin());
        return userRepository.save(user);
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
