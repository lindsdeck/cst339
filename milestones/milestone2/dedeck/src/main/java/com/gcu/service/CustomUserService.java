package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("=== DEBUG: loadUserByUsername called with: " + username);
    
    UserEntity user = userRepository.findByUsername(username);
    
    if (user == null) {
        System.out.println("=== DEBUG: User not found: " + username);
        throw new UsernameNotFoundException("User not found: " + username);
    }

    System.out.println("=== DEBUG: User found: " + user.getUsername());
    System.out.println("=== DEBUG: Password from DB: " + user.getPassword());
    
    return User.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .roles("USER")
        .build();
}
}