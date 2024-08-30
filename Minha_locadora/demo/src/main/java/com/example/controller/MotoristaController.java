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

import com.example.demo.Motorista;
import com.example.demo.User;
import com.example.service.MotoristaService;
import com.example.controller.UserController; // Ainda usa o UserController como serviço

@RestController
@RequestMapping("/api")
public class MotoristaController {

    @Autowired
    private UserController userService; 

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping("/motorista")
    public Motorista save(@RequestBody Motorista motoristaObj) {
        motoristaService.save(motoristaObj);
        return motoristaObj;
    }

    @GetMapping("/motorista")
    public List<Motorista> get() {
        return motoristaService.get();
    }

    @GetMapping("/motorista/{id}")
    public Motorista get(@PathVariable int id) {
        Motorista motoristaObj = motoristaService.get(id);
        if (motoristaObj == null) {
            throw new RuntimeException("Motorista not found for the Id:" + id);
        }
        return motoristaObj;
    }

    @PutMapping("/motorista")
    public Motorista update(@RequestBody Motorista motoristaObj) {
        motoristaService.save(motoristaObj);
        return motoristaObj;
    }

    @DeleteMapping("/motorista/{id}")
    public String delete(@PathVariable int id) {
        motoristaService.delete(id);
        return "Motorista has been deleted with id:" + id;
    }

    @GetMapping("/users/{userId}/motoristas")
    public List<Motorista> getMotoristasByUser(@PathVariable Long userId) {
        return motoristaService.getMotoristasByUserId(userId);
    }

    @PostMapping("/users/{userId}/motoristas")
    public Motorista addMotoristaToUser(@PathVariable Long userId, @RequestBody Motorista motorista) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found for the Id:" + userId);
        }
        motorista.setUser(user);
        motoristaService.save(motorista);
        return motorista;
    }
}