package ru.knasys.springinactioon5.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.knasys.springinactioon5.db.UserRepository;
import ru.knasys.springinactioon5.entities.User;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    private UserRepository userRepo;

    public UserRepositoryUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String usrname) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(usrname);
        if (user == null) throw new UsernameNotFoundException("User " + usrname + " not found");
        return user;
    }
}
