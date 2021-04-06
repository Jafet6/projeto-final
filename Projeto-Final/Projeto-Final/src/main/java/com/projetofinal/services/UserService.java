package com.projetofinal.services;

import com.projetofinal.domains.Product;
import com.projetofinal.domains.User;
import com.projetofinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user) throws Exception {
        userRepository.save(user);
        return user;
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
