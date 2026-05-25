package com.roadready.controller;

import com.roadready.dto.AuthResponse;
import com.roadready.dto.LoginRequest;
import com.roadready.model.User;
import com.roadready.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginRequest loginRequest) {
        AuthResponse response = userService.authenticateUser(loginRequest);
        return ResponseEntity.ok(response);
    }


}
