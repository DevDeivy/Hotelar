package com.hotelar.hotelar_backend.application.services;

import com.hotelar.hotelar_backend.api.dto.ChangePasswordDTO;
import com.hotelar.hotelar_backend.api.dto.UserDTO;
import com.hotelar.hotelar_backend.domain.models.User;
import com.hotelar.hotelar_backend.infraestructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUser(UserDTO userDTO){
        if (userRepository.existsByEmail(userDTO.getEmail())){
            throw new IllegalArgumentException("this email already exists");
        }
        User user = UserDTOtoUser(userDTO);
        return userRepository.save(user);
    }

    public User UserDTOtoUser(UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        return user;
    }

    public ResponseEntity<String> changePassword(Long id, @RequestBody ChangePasswordDTO changePasswordDTO){
        var userOptional = userRepository.findById(id);
        if(!userRepository.existsById(id) || userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credentials invalid please try again");
        }
        User user = userOptional.get();
        user.setPassword(bCryptPasswordEncoder.encode(changePasswordDTO.getPassword()));
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Password changed");
    }

    public ResponseEntity<String> deleteEmployee(Long id){
        if(!userRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credentials invalid please try again");
        }
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee deleted");
    }
}
