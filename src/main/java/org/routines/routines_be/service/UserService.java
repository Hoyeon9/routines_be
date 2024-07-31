package org.routines.routines_be.service;

import org.routines.routines_be.dto.LoginRequestDTO;
import org.routines.routines_be.dto.LoginResponseDTO;
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

        if (user != null && user.getUserPassword().equals(loginRequest.getPassword())) {
            // For simplicity, plain password check. Use hashed password comparison in production.
            LoginResponseDTO response = new LoginResponseDTO();
            response.setMessage("Login successful!");
            return response;
        } else {
            throw new RuntimeException("Invalid id or password.");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(Long id, User user) {
        userRepository.deleteById(id);
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
