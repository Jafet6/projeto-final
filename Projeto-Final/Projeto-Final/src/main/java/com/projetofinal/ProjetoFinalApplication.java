package com.projetofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjetoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalApplication.class, args);
	}

}
