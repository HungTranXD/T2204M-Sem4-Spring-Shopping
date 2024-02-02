package com.example.t2204msem4springshopping.service;

import com.example.t2204msem4springshopping.entity.CustomUserDetail;
import com.example.t2204msem4springshopping.entity.User;
import com.example.t2204msem4springshopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
                );

        return new CustomUserDetail(user);
    }
}
