package com.j24.security.template.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Configuration
public class BasicConfig {

    // bean przykładowy
    @Bean
    public String myNameBean(){
        // generowanie randomowego Strenga
        String randomString =  UUID.randomUUID().toString();
        return "Darek - " + randomString.substring(0,5);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
