package com.mantis.config;

import com.mantis.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

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

        return http.
        csrf(c->c.disable()).cors(cors->cors.configurationSource(getCorsConfigurationSource()))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("api/v1/auth/login",
                                        "api/v1/user/create-user","api/v1/email/**","api/v1/auth/me","api/v1/user/user-verify-by-code")
                                .permitAll().anyRequest().authenticated()).addFilterBefore(
                        authenticationFilter, BearerTokenAuthenticationFilter.class
                ).build();

    }

    @Bean
    public CorsConfigurationSource getCorsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedOriginPatterns(Arrays.asList("**"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
