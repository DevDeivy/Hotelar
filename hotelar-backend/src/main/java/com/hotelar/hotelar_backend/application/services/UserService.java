package com.hotelar.hotelar_backend.application.services;

import com.hotelar.hotelar_backend.api.dto.ChangePasswordDTO;
import com.hotelar.hotelar_backend.api.dto.GenerateJwtDTO;
import com.hotelar.hotelar_backend.api.dto.UserDTO;
import com.hotelar.hotelar_backend.domain.models.User;
import com.hotelar.hotelar_backend.infraestructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final GenerateJwtService generateJwtService;

    public ResponseEntity<Object> createUser(@RequestParam UserDTO userDTO){
        User user = new User();
        GenerateJwtDTO generateJwtDTO = new GenerateJwtDTO();
        if (userRepository.existByEmail(userDTO.getEmail()) || !userRepository.existsById(user.getId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("this email is already exist");
        }
        var response = new HashMap<>();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        generateJwtDTO.setToken(generateJwtService.tokenWithoutClaims(user));
        var token = generateJwtDTO.getToken();
        response.put("User created", user);
        response.put("Token: ", token);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Object> changePassword(Long id, @RequestBody ChangePasswordDTO changePasswordDTO){
        var userOptional = userRepository.findById(id);
        if(!userRepository.existsById(id) || userOptional.isEmpty()){
            return ResponseEntity.badRequest().body("enter a valid id");
        } else if (!changePasswordDTO.getPassword().equals(changePasswordDTO.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("please enter a valid credentials");
        }
        User user = userOptional.get();
        user.setPassword(bCryptPasswordEncoder.encode(changePasswordDTO.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok().body("Password changed successfully");
    }
}
