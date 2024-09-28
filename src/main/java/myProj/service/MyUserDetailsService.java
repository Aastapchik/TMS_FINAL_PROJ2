package myProj.service;

import myProj.config.UserDetailsConfig;
import myProj.dataBase.request.user.UserRequestDB;
import myProj.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(UserRequestDB.findUserByUsername(username));
        return user.map(UserDetailsConfig::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
