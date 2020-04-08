package ru.knasys.springinactioon5.entities;

import lombok.Data;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(){
        return new User(
                username,
                encoder.encode(password),
                fullname,
                street,
                city,
                state,
                zip,
                phone
        );
    }
}
