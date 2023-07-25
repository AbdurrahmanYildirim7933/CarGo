package com.mantis.config;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.mantis.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig{

    @Autowired AuthenticationFilter  authenticationFilter;
    @Bean
 public BCryptPasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
 }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("api/v1/auth/login",
                                        "api/v1/user/create-user","api/v1/email/verify")
                                .permitAll().anyRequest().authenticated()).addFilterBefore(
                        authenticationFilter, BearerTokenAuthenticationFilter.class
                ).build();

    }

}
