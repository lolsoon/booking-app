package com.vti.config.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.google.common.collect.ImmutableList;
import com.vti.service.IUserService;

@Component
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .authorizeRequests()
//                .antMatchers("/api/v1/login").anonymous()
//                .antMatchers("/api/v1/users/profile").authenticated()
//                .antMatchers(HttpMethod.DELETE).hasAnyAuthority("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/v1/tours/**",
//                        "/api/v1/hotels/**",
//                        "api/v1/flights/**",
//                        "api/v1/bookings/**").hasAnyAuthority("ADMIN")
//                .antMatchers(HttpMethod.POST, "/api/v1/tours/**",
//                        "/api/v1/hotels/**",
//                        "api/v1/flights/**",
//                        "api/v1/bookings/**").hasAnyAuthority("ADMIN")
//                .antMatchers("/api/v1/users/**").hasAnyAuthority("ADMIN")
//                .antMatchers(HttpMethod.GET, "/api/v1/tours/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/v1/bookings/**").permitAll()
//                .antMatchers("/api/FileUpload/files/**").permitAll()
//                .antMatchers("/api/v1/files/**").permitAll()
//                .anyRequest().authenticated()
                .authorizeRequests()
                .antMatchers("/api/v1/login").anonymous()
                .antMatchers("/api/v1/users/profile").authenticated()
                .antMatchers("/api/v1/users/**").permitAll()
                .antMatchers("/api/v1/groups").permitAll()
                .antMatchers("/api/v1/tours/**").permitAll()
                .antMatchers("/api/v1/bookings/**").permitAll()
                .antMatchers("/api/v1/hotels/**").permitAll()
                .antMatchers("/api/v1/flights/**").permitAll()
                .antMatchers("/api/FileUpload/files/**").permitAll()
                .antMatchers("/api/v1/files/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .cors()
                .and()
                .csrf().disable()
                .addFilterBefore(
                        new JWTAuthenticationFilter("/api/v1/login", authenticationManager(), service),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(
                        new JWTAuthorizationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(ImmutableList.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        configuration.applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}