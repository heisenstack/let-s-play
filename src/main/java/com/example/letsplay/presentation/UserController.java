package com.example.letsplay.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.letsplay.application.RegisterRequest;
import com.example.letsplay.domain.User;
import com.example.letsplay.application.UserDto;
import com.example.letsplay.application.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@RequestBody RegisterRequest registerRequest) {
        return userService.registerUser(registerRequest);
    }
}