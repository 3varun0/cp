package com.ms.project10.sec.authDB.app.web.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthDBSecurityConfigurer extends WebSecurityConfigurerAdapter {

    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled, FROM account_holders WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username authority FROM roles WHERE username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
    }
}
