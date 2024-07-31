package org.routines.routines_be.service;

import org.routines.routines_be.dto.LoginRequestDTO;
import org.routines.routines_be.dto.LoginResponseDTO;
import org.routines.routines_be.dto.RegisterRequestDTO;
import org.routines.routines_be.entity.User;
import org.routines.routines_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        User user = userRepository.findByUserId(loginRequest.getUserId());

        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // For simplicity, plain password check. Use hashed password comparison in production.
            LoginResponseDTO response = new LoginResponseDTO();
            response.setMessage("Login successful!");
            return response;
        } else {
            throw new RuntimeException("Invalid id or password.");
        }
    }

    public void register(RegisterRequestDTO registerRequest) {
        if(userRepository.findByUserId(registerRequest.getUserId()) == null && userRepository.findByEmail(registerRequest.getEmail()) == null) {
            User user = new User();
            user.setUserId(registerRequest.getUserId());
            user.setEmail(registerRequest.getEmail());
            user.setPassword(registerRequest.getPassword());
            user.setUsername(registerRequest.getUsername());
            userRepository.save(user);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
    public User updateUser(Long id, User user) {
        userRepository.deleteById(id);
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
