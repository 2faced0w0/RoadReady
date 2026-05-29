package com.cms.controller;

import com.cms.dto.LoginResponseDto;
import com.cms.model.User;
import com.cms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public LoginResponseDto login(Principal principal){
        String loggedInUsername=principal.getName();
        User user=(User)userService.loadUserByUsername(loggedInUsername);
        return new LoginResponseDto(user.getId(),
                user.getUsername(),
                user.getRole().toString());
    }
}
