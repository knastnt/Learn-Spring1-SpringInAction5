package ru.knasys.springinactioon5.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("kostya")
                .password("{noop}123")
                .authorities("ROLE_USER")
                .and()
                .withUser("vasya")
                .password("{noop}1")
                .authorities("ROLE_USER");
    }
}
