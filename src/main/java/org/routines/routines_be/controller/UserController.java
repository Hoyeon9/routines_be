package org.routines.routines_be.controller;

import org.routines.routines_be.dto.LoginRequestDTO;
import org.routines.routines_be.dto.LoginResponseDTO;
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
}
