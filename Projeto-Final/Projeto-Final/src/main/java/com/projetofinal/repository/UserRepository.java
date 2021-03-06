package com.projetofinal.repository;

import com.projetofinal.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    User findByLogin(String login);

    boolean existsByCpfOrLogin(String cpf, String login);

}
