package com.example.thymeleafspring.bean;

import com.example.thymeleafspring.auditor.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorrAwareBean")
public class AuditorAwareBean {
    @Bean
    public AuditorAware<String> auditorrAwareBean() {
        return new AuditorAwareImpl();

    }

}
