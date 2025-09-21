package com.hotelar.hotelar_backend.api.controller;

import com.hotelar.hotelar_backend.api.dto.ChangePasswordDTO;
import com.hotelar.hotelar_backend.api.dto.UserDTO;
import com.hotelar.hotelar_backend.api.dto.UserResponseDTO;
import com.hotelar.hotelar_backend.application.services.GenerateJwtService;
import com.hotelar.hotelar_backend.application.services.UserService;
import com.hotelar.hotelar_backend.domain.models.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final GenerateJwtService generateJwtService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserDTO userDTO){
        User createdUser = userService.createUser(userDTO);
        String token = generateJwtService.tokenWithoutClaims(createdUser);
        UserResponseDTO response = new UserResponseDTO(createdUser, token);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/hola")
    public String hola(){
        return "hola";
    }

    @PutMapping("/reset/{id}")
    public ResponseEntity<String> changePassword(@PathVariable Long id,@RequestBody @Valid ChangePasswordDTO changePasswordDTO){
        return userService.changePassword(id, changePasswordDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return userService.deleteEmployee(id);
    }
}
