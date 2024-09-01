package com.example.controller;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.demo.Carrinho;
import com.example.demo.RegisterRequest;

@RestController
@RequestMapping("/api")
public class UserController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        try {
            User user = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                                     .setParameter("email", email)
                                     .getSingleResult();
            if (user != null && user.getPassword().equals(password)) {
                return ResponseEntity.ok("Login successful");
            }
        } catch (Exception e) {
            // Handle case where no result is found
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        List<User> existingUsers = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                                                .setParameter("email", request.getEmail())
                                                .getResultList();
        if (!existingUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O e-mail já existe");
        }

        // Criando um novo usuário
        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        entityManager.persist(newUser);

        // Criando um novo carrinho para o usuário
        Carrinho newCarrinho = new Carrinho();
        newCarrinho.setUser(newUser);
        entityManager.persist(newCarrinho);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario e carrinho criados com sucesso");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return ResponseEntity.ok(users);
    }

    public User getUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }
}
