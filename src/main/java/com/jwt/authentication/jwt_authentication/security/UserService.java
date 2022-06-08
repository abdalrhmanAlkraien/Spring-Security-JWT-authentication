package com.jwt.authentication.jwt_authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements UserDetailsService {

    // from the loadUserByUsername step in the senior we need to get user details the UserDetailsService is interface provide from spring security
    // User here from spring security too and will take a three parameter username password and collection of authorities
    // AuthorityUtils.NO_AUTHORITIES will return empty list
    // the password will pass as encrypted
    // PasswordEncoder provide from spring security, and we need it to encrypted the password

    // for inject UserRepository inside userService
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("",passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES);
    }

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public void saveUser(UserApp userApp){
        userApp.setPassword(passwordEncoder().encode(userApp.getPassword())); // for encrypt
        userRepository.save(userApp);
    }

    public List<UserApp> findAllUser(){
        return userRepository.findAll();
    }
}
