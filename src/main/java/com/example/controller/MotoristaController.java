package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MotoristaDTO;
import com.example.dto.UserDTO;
import com.example.service.MotoristaService;
import com.example.service.UserService;

@RestController
@RequestMapping("/api")
public class MotoristaController {

    @Autowired
    private UserService userService;

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping("/motorista")
    public MotoristaDTO save(@RequestBody MotoristaDTO motoristaDTO) {
        motoristaService.save(motoristaDTO);
        return motoristaDTO;
    }

    @GetMapping("/motorista")
    public List<MotoristaDTO> get() {
        return motoristaService.get();
    }

    @GetMapping("/motorista/{id}")
    public MotoristaDTO get(@PathVariable int id) {
        MotoristaDTO motoristaDTO = motoristaService.get(id);
        if (motoristaDTO == null) {
            throw new RuntimeException("Motorista not found for the Id:" + id);
        }
        return motoristaDTO;
    }

    @PutMapping("/motorista")
    public MotoristaDTO update(@RequestBody MotoristaDTO motoristaDTO) {
        motoristaService.save(motoristaDTO);
        return motoristaDTO;
    }

    @DeleteMapping("/motorista/{id}")
    public String delete(@PathVariable int id) {
        motoristaService.delete(id);
        return "Motorista has been deleted with id:" + id;
    }

    @GetMapping("/users/{userId}/motoristas")
    public List<MotoristaDTO> getMotoristasByUser(@PathVariable Long userId) {
        return motoristaService.getMotoristasByUserId(userId);
    }

    @PostMapping("/users/{userId}/motoristas")
    public MotoristaDTO addMotoristaToUser(@PathVariable Long userId, @RequestBody MotoristaDTO motoristaDTO) {
        UserDTO userDTO = userService.getUserById(userId);
        if (userDTO == null) {
            throw new RuntimeException("User not found for the Id:" + userId);
        }
        motoristaDTO.setUser(userDTO);
        motoristaService.save(motoristaDTO);
        return motoristaDTO;
    }
}
