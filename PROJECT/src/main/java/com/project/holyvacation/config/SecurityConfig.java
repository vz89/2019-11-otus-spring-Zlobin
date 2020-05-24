package com.project.holyvacation.config;

import com.project.holyvacation.security.jwt.JwtConfigurer;
import com.project.holyvacation.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String API_PUBLIC_VACATIONS_ENDPOINT = "/api/public-vacations/";
    private static final String ADMIN_ENDPOINT = "/api/admin";
    private static final String LOGIN_ENDPOINT = "/api/auth/login/**";
    private static final String REGISTER_USER_ENDPOINT = "/api/user/";
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ACTUATOR_ENDPOINT = "/actuator/**";

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, REGISTER_USER_ENDPOINT).permitAll()
                .antMatchers(LOGIN_ENDPOINT, API_PUBLIC_VACATIONS_ENDPOINT).permitAll()
                .antMatchers(ADMIN_ENDPOINT, ACTUATOR_ENDPOINT).hasRole(ROLE_ADMIN)
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }


}
