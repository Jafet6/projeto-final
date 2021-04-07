package com.projetofinal.auth.config;//package com.projetofinal.auth.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.*;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/usuario", "/carros" ).permitAll()
//                .antMatchers(HttpMethod.GET, "/usuario", "/carros/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/usuario", "/carros/**").authenticated()
//                .antMatchers(HttpMethod.PUT, "/usuario", "/carros/**").authenticated();
//    }		}

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/user", "/product").permitAll()
                .antMatchers(HttpMethod.GET,"/user", "/product/**","/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/user", "/product/**").authenticated()
                .antMatchers(HttpMethod.PUT,"/user", "/product/**").authenticated();
    }
}