package com.hemanagachand.code_pulse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hemanagachand.code_pulse.dto.UserRequest;
import com.hemanagachand.code_pulse.dto.UserResponse;
import com.hemanagachand.code_pulse.dto.UserUpdateRequest;
import com.hemanagachand.code_pulse.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(
            UserService userService) {

        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(
            @RequestBody UserRequest request) {

        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(
            @PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(
            @PathVariable Long id,
            @RequestBody UserUpdateRequest request) {

        return userService.updateUser(
                id,
                request);
    }
}