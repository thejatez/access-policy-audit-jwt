package com.example.access.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig{
@Bean
SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
http.csrf(csrf->csrf.disable())
.addFilterBefore(new JwtFilter(),org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
.authorizeHttpRequests(a->a.anyRequest().permitAll());
return http.build();
}}