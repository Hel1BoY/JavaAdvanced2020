package com.example.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collection;

@Configuration
public class ConfigAuth extends WebSecurityConfigurerAdapter {

    //@Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        UserDetails newUser1 = User.withUsername("test")
                .password("1234")
                .roles("user")
                .build();

        UserDetails newUser2 = User.withUsername("Vasko")
                .password("4321")
                .roles("admin")
                .build();

        userDetailsService.createUser(newUser1);
        userDetailsService.createUser(newUser2);

        return userDetailsService;
    }

    //@Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests()
                .antMatchers("/test").hasAnyRole("user","admin")
                .antMatchers("/delete").hasRole("admin");
    }
}
