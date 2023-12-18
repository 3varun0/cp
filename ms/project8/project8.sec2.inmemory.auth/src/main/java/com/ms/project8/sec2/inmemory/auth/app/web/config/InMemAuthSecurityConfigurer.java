package com.ms.project8.sec2.inmemory.auth.app.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class InMemAuthSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("Varun").password("1111").roles("USER")
                .and()
                .withUser("Mahesh").password("2222").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.antMatcher("/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }
}
