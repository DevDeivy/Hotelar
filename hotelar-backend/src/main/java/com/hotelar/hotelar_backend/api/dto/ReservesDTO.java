package com.hotelar.hotelar_backend.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservesDTO {
    @NotNull
    private Long roomId;
    @NotNull
    private Integer days;
}
