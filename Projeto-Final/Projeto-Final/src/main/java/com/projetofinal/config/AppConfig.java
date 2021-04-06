package com.projetofinal.config;

import com.projetofinal.utils.date.DateUTC;
import com.projetofinal.mappers.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserMapper userMapper() {
        return new UserMapper(new ModelMapper());
    }

    @Bean
    public DateUTC dateUTC() {
        return new DateUTC();
    }
}


