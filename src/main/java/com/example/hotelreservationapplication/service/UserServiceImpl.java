package com.example.hotelreservationapplication.service;

import com.example.hotelreservationapplication.entity.User;
import com.example.hotelreservationapplication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        return userRepository.save(user);
}


}

