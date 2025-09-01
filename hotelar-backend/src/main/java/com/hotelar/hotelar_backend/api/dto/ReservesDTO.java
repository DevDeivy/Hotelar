package com.hotelar.hotelar_backend.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservesDTO {
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime finishDate;
    @NotNull
    private String state;

}
