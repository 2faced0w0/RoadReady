package com.roadready.service;

import com.roadready.dto.AuthResponseDto;
import com.roadready.dto.LoginResponseDto;
import com.roadready.exception.CustomerNotFoundException;
import com.roadready.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    public void addUser(User user){
        userRepository.save(user);
    }

    public AuthResponseDto authenticateUser(LoginResponseDto loginResponseDto){

        User user=userRepository.findByEmail(loginResponseDto.getEmail())
                .orElseThrow(() -> new CustomerNotFoundException("Invalid credentials"));

//        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
//            throw new RuntimeException("Invalid email or password");
//        }

        //JWT based auth artifact - holds JWT logic
        String JWT="dummytoken";

        return new AuthResponseDto("Login Successful!", user.getId(), user.getRole().name());
    }
}
