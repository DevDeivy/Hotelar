package com.hotelar.hotelar_backend.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    @NotNull
    private String number;

    @NotNull
    private String typeRoom;

    @NotNull
    private String stateRoom;
}
