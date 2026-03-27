package com.worksupport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // 👇 Login page should be public
                        .requestMatchers("/login", "/css/**", "/js/**", "/error", "/favicon.ico").permitAll()

                        // 👇 Home requires login
                        .requestMatchers("/").authenticated()

                        .anyRequest().authenticated()
                )

                // 🔐 Custom Login
                .formLogin(form -> form
                        .loginPage("/login")                // show login first
                        .loginProcessingUrl("/doLogin")     // form action URL
                        .defaultSuccessUrl("/", true)       // after login → home
                        .failureUrl("/login?error=true")    // if login fails
                        .permitAll()
                )

                // 🔓 Logout
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                );

        return http.build();
    }
}