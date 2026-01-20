package com.securecode.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Use HTTPS
        http.requiresChannel().anyRequest().requiresSecure();

        // Enable CSRF protection
        http.csrf().antMatcher("/**").and()
            .authorizeRequests()
            .anyRequest().authenticated();

        // Ensure headers are set correctly
        http.headers().frameOptions().sameOrigin();  // Prevent clickjacking
        http.headers().httpStrictTransportSecurity(); // HSTS
        http.headers().contentSecurityPolicy("default-src 'self'"); // CSP

        // Add any additional filters for authentication/authorization
        http.addFilterBefore(new CustomAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    // Define any additional beans here
    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() {
        return new CustomAuthenticationFilter();
    }
}