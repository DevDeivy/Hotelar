package com.hotelar.hotelar_backend.api.controller;

import com.hotelar.hotelar_backend.api.dto.RoomDTO;
import com.hotelar.hotelar_backend.application.services.RoomService;
import com.hotelar.hotelar_backend.domain.models.Room;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/")
    public ResponseEntity<Object> getRooms(){
        return roomService.getRooms();
    }

    @PostMapping("/create")
    public ResponseEntity<RoomDTO> createRoom(@RequestBody @Valid RoomDTO roomDTO){
        Room room = roomService.createRoom(roomDTO);
        RoomDTO response = new RoomDTO(
                room.getId(),
                room.getRoomNumber(),
                room.getTypeRoom(),
                room.getStateRoom(),
                room.getPriceRoom(),
                null,
                null
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable Long id){
        return roomService.deleteRoom(id);
    }
}
