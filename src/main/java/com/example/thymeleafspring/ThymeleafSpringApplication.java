package com.example.thymeleafspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//Auditing

@SpringBootApplication
/*
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")*/
public class ThymeleafSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafSpringApplication.class, args);
    }

}
