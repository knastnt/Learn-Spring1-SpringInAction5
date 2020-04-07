package ru.knasys.springinactioon5.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("userRepositoryUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

//        auth.inMemoryAuthentication()
//                .withUser("kostya")
//                .password("{noop}123")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("vasya")
//                .password("{noop}1")
//                .authorities("ROLE_USER");

//        auth.ldapAuthentication()  Нихрена не работает мой LDAP
//                .userSearchFilter("(uid={0})")
//                .groupSearchFilter("member={0}")
//                .passwordCompare()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .passwordAttribute("passcode")
//                .and()
//                .contextSource()
//                .url("ldap://192.168.0.250:389/dc=pb");

        auth.userDetailsService(userDetailsService)
        .passwordEncoder(encoder());
    }

    @Bean
    public PasswordEncoder encoder(){ /* тупо открытый текст*/
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        };
//        return new StandardPasswordEncoder("53cr3t");
    }
}
