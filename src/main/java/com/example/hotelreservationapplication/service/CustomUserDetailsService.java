package com.example.hotelreservationapplication.service;

import com.example.hotelreservationapplication.entity.User;
import com.example.hotelreservationapplication.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    public final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{

        User user= userRepository.findByUserName(username).orElseThrow(()->new UsernameNotFoundException("User Not Found"));

        return
                 org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
                         .password(user.getPassword())
                         .roles("USER")
                         .build();

    }
}
