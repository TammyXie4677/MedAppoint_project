package com.example.medappointdemo.service;

import com.example.medappointdemo.entity.User;
import com.example.medappointdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Ensure this is correctly injected

    public void registerUser(User user, String confirmPassword) {
        if (!isPasswordMatching(user.getPassword(), confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); // Use the injected encoder
        userRepository.save(user);
    }

    private boolean isPasswordMatching(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }
}
