package com.example.thymeleafspring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderBean {

    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoderBean(){
        return new BCryptPasswordEncoder();
    }
}
