package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
public class AppConfig {

    @Bean
    public ApplicationContext context() {
        return new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
