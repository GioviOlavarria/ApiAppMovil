package com.example.miapp.controller;

import com.example.miapp.model.User;
import com.example.miapp.model.Role;
import com.example.miapp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        // Ignoramos el id si viene desde el cliente
        user.setId(null);


        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }

        return userRepository.save(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());

        if (userDetails.getRole() != null) {
            user.setRole(userDetails.getRole());
        }

        return userRepository.save(user);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}