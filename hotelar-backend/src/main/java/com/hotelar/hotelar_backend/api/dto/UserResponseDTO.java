package com.hotelar.hotelar_backend.api.dto;

import com.hotelar.hotelar_backend.domain.models.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    @NotNull
    private String email;

    @NotNull
    private String name;

    private String lastName;

    @NotNull
    private String token;

    public UserResponseDTO(User user, String token) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.token = token;
    }
}
