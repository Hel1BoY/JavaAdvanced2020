package com.example.GameStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();

        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/v01/**");

        http.authorizeRequests()
                .anyRequest().authenticated().and()
                .httpBasic();

        http.headers().frameOptions().sameOrigin();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("Vasko")
                .password("{noop}1234")
                .roles("ADMIN");

        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select username,password,enabled from user where username = ?")
                .authoritiesByUsernameQuery("select username, user.role as authority from user where username = ?");
    }


}
