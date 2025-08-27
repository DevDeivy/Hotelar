package com.hotelar.hotelar_backend.api.controller;

import com.hotelar.hotelar_backend.api.dto.UserDTO;
import com.hotelar.hotelar_backend.application.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO userDTO){
        return userService.createUser(userDTO);
    }
}
