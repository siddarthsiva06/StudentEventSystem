package com.example.studentservice.config;

import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.*;

@Configuration
public class PasswordConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}