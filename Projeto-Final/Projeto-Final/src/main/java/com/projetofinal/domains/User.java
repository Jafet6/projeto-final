package com.projetofinal.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Max(80)
    @Column(length = 80, nullable = false)
    private String name;

    @NotBlank
    @NotEmpty
    @CPF
    @Column(unique = true, nullable = false)
    private String cpf;

    @NotBlank
    @NotEmpty
    @Column(unique = true, nullable = false)
    @Size(min = 5, max = 20)
    private String login;

    private String password;

    public User(String name, String cpf, String login, String password) {
        this.name = name;
        this.cpf = cpf;
        this.login = login;
        this.password = password;
    }
}
