package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDTO;
import com.example.mapper.UserMapper;
import com.example.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return UserMapper.toDTO(user);
    }

    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return UserMapper.toDTO(user);
	}
	
    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
