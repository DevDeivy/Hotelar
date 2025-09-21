package com.hotelar.hotelar_backend.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private Long id;

    @NotNull
    private String roomNumber;

    @NotNull
    private String typeRoom;

    @NotNull
    private String stateRoom;

    @NotNull
    private Integer priceRoom;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;
}
