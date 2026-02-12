// src/main/java/com/example/letsplay/presentation/UserController.java
package com.example.letsplay.presentation;

import com.example.letsplay.application.UserService;
import com.example.letsplay.application.dto.RegisterRequest;
import com.example.letsplay.application.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity; 
import java.security.Principal;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor Injection for the UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@RequestBody RegisterRequest registerRequest) {
        return userService.registerUser(registerRequest);
    }
    @GetMapping("/me")
public ResponseEntity<UserDto> getCurrentUser(Principal principal) {
    // The 'Principal' object is automatically injected by Spring Security
    // It contains the details of the authenticated user (in our case, the email)
    UserDto user = userService.findUserByEmail(principal.getName());
    return ResponseEntity.ok(user);
}
}