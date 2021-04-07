package com.projetofinal.auth.config;//package com.projetofinal.auth.config;
//
//import com.projetofinal.repository.UserRepository;
//import com.projetofinal.requests.UserLoginRequest;
//import com.projetofinal.responses.UserResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
//                "/configuration/security", "/swagger-ui.html", "/webjars/*", "/h2-console/*");
//    }
//
//    @Bean
//    public AuthenticationManager customAuthenticationManager() throws Exception {
//        return authenticationManagerBean();
//    }
//
//    @Bean
//    public static BCryptPasswordEncoder passwordEncoder() {
//
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    public void authenticationManager(AuthenticationManagerBuilder builder,
//                                      UserRepository userRepository)
//            throws Exception {
//        if (userRepository.count() == 0) {
//            UserLoginRequest userLogin = new UserLoginRequest();
//            userLogin.setUsername("admin");
//            userLogin.setPassword(passwordEncoder().encode("admin"));
//            userRepository.save(userLogin);
//        }
//        builder.userDetailsService(name -> new UserResponse(userRepository.findByName(name)))
//                .passwordEncoder(passwordEncoder());
//    }
//}


import com.projetofinal.DTO.authenticated.UserCustomDTO;
import com.projetofinal.domains.User;
import com.projetofinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/v2/api-docs","/configuration/ui","/swagger-resource/**",
                "/configuration/security", "/swagger-ui.html", "webjars/**", "/h2-console/**");}
    @Bean
    public AuthenticationManager customAuthenticationManager()throws Exception{
        return authenticationManagerBean();}

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws  Exception {
        if (userRepository.count() == 0 ){

            User user= new User();
            user.setLogin("admin");
            user.setPassword(passwordEncoder().encode("admin"));
            userRepository.save(user);}
        builder.userDetailsService(login -> new UserCustomDTO(userRepository.findByLogin(login)))
                .passwordEncoder(passwordEncoder());
    }
}