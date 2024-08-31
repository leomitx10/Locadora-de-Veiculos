package in.bushansirgur.springboot.crudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.bushansirgur.springboot.crudapi.dto.UserDTO;
import in.bushansirgur.springboot.crudapi.model.RegisterRequest;
import in.bushansirgur.springboot.crudapi.mapper.UserMapper;
import in.bushansirgur.springboot.crudapi.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        UserDTO userDTO = userService.getUserByEmail(email);
        if (userDTO != null && userDTO.getPassword().equals(password)) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        UserDTO existingUser = userService.getUserByEmail(request.getEmail());
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
        UserDTO newUserDTO = new UserDTO();
        newUserDTO.setEmail(request.getEmail());
        newUserDTO.setPassword(request.getPassword());
        userService.save(UserMapper.toEntity(newUserDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers()
                                         .stream()
                                         .map(UserMapper::toDTO)
                                         .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
}
