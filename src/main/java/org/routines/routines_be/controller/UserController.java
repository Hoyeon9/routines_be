package org.routines.routines_be.controller;

import org.routines.routines_be.dto.*;
import org.routines.routines_be.entity.User;
import org.routines.routines_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequest) {
        return userService.login(loginRequest);
    }
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDTO registerRequest) {
        userService.register(registerRequest);
    }
    @GetMapping
    public UserResponseDTO getUserInfo(@RequestBody UserIdDTO userId){
        User user = userService.getUserByUserId(userId.getUserId());
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setUsername(user.getUsername());
        responseDTO.setEmail(user.getEmail());
        return responseDTO;
    }
}
