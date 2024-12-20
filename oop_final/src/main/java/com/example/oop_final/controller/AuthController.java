package com.example.oop_final.controller;

import com.example.oop_final.model.Role;
import com.example.oop_final.model.User;
import com.example.oop_final.service.RoleService;
import com.example.oop_final.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register a new user
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Assign default role as "MEMBER"
        Role memberRole = roleService.getRoleByName("MEMBER");
        user.setRole(memberRole);
        return userService.saveUser(user);
    }

    // Assign a role to an existing user (Admin only)
    @PostMapping("/assign-role")
    public User assignRole(@RequestParam Long userId, @RequestParam String roleName) {
        User user = userService.getUserById(userId);
        Role role = roleService.getRoleByName(roleName);
        user.setRole(role);
        return userService.saveUser(user);
    }

    // Login endpoint (Spring Security handles authentication)
    @PostMapping("/login")
    public String login() {
        return "Login successful!";
    }
}
