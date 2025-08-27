package com.hotelar.hotelar_backend.application.services;

import com.hotelar.hotelar_backend.api.dto.UserDTO;
import com.hotelar.hotelar_backend.domain.models.User;
import com.hotelar.hotelar_backend.infraestructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<Object> createUser(@RequestParam UserDTO userDTO){
        if (userRepository.existByEmail(userDTO.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("this email is already exist");
        }
        User user = new User();
        var response = new HashMap<>();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        response.put("User created", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
