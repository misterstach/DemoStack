package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/users").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form // la page n'existe pas encore > Angular
                        .loginPage("/login")
                        .permitAll()
                )
                .oauth2Login((oauth2) -> oauth2 // la page n'existe pas encore > Angular
                        .loginPage("/login")
                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
}