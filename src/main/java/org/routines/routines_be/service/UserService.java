package org.routines.routines_be.service;

import jakarta.transaction.Transactional;
import org.routines.routines_be.dto.LoginRequestDTO;
import org.routines.routines_be.dto.LoginResponseDTO;
import org.routines.routines_be.dto.RegisterRequestDTO;
import org.routines.routines_be.dto.UserIdDTO;
import org.routines.routines_be.entity.Routine;
import org.routines.routines_be.entity.User;
import org.routines.routines_be.repository.RoutineRepository;
import org.routines.routines_be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoutineRepository routineRepository;

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        User user = userRepository.findByUserId(loginRequest.getUserId());

        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // For simplicity, plain password check. Use hashed password comparison in production.
            LoginResponseDTO response = new LoginResponseDTO();
            response.setMessage("Login successful!");
            response.setToken(loginRequest.getUserId());
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
    public void updateUser(RegisterRequestDTO registerRequest) {
        userRepository.updateByUserId(registerRequest.getUserId(), registerRequest.getPassword(), registerRequest.getUsername(), registerRequest.getEmail());
    }
    @Transactional
    public void deleteUser(UserIdDTO userId) {
        List<Routine> restRoutines = routineRepository.findByUserIdRoutine(userId.getUserId());
        if(!restRoutines.isEmpty()) {
            for(Routine r : restRoutines) {
                routineRepository.deleteByRoutineId(r.getRoutineId());
            }
        }
        userRepository.deleteByUserId(userId.getUserId());
    }
}
