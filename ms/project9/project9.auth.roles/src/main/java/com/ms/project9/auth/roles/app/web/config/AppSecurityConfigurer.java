package com.ms.project9.auth.roles.app.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Varun").password("{noop}1111").roles("USER")
                .and()
                .withUser("Mahesh").password("{noop}2222").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/authroles/adminpage").hasRole("ADMIN")
                .antMatchers("/authroles/userpage").hasAnyRole("USER", "ADMIN")
                .antMatchers("/authroles/hello").permitAll()
                .and()
                .formLogin();
    }
}
