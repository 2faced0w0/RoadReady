package com.roadready.service;

import com.roadready.dto.AuthResponse;
import com.roadready.dto.LoginRequest;
import com.roadready.exception.UserNotFoundException;
import com.roadready.model.User;
import com.roadready.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    public void addUser(User user){
        userRepository.save(user);
    }

    public AuthResponse authenticateUser(LoginRequest loginRequest){

        User user=userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Invalid credentials"));

//        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
//            throw new RuntimeException("Invalid email or password");
//        }

        //JWT based auth artifact - holds JWT logic
        String JWT="dummytoken";

        return new AuthResponse("Login Successful!", user.getId(), user.getRole().name());
    }
}
