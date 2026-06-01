package com.roadready.service;

import com.roadready.dto.AuthResponseDto;
import com.roadready.dto.LoginResponseDto;
import com.roadready.exception.CustomerNotFoundException;
import com.roadready.model.Customer;
import com.roadready.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    //private final PasswordEncoder passwordEncoder;

    public void addUser(Customer customer){
        customerRepository.save(customer);
    }

//    public AuthResponseDto authenticateUser(LoginResponseDto loginResponseDto){
//
//        Customer customer= customerRepository.findByEmail(loginResponseDto.getEmail())
//                .orElseThrow(() -> new CustomerNotFoundException("Invalid credentials"));
//
////        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
////            throw new RuntimeException("Invalid email or password");
////        }
//
//        //JWT based auth artifact - holds JWT logic
//        String JWT="dummytoken";
//
//        return new AuthResponseDto("Login Successful!", customer.getId(), customer.getRole().name());
//    }
}
