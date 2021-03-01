package com.example.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecondConfig extends WebSecurityConfigurerAdapter {

@Override
    protected void configure(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/h2-console/**")
                .permitAll()
                .and()
                .formLogin();

        httpSecurity.authorizeRequests()
                .anyRequest()
                .hasRole("USER");

        httpSecurity.csrf()
                .ignoringAntMatchers("/h2-console/**");
        httpSecurity.headers()
                .frameOptions()
                .sameOrigin();


    }
}