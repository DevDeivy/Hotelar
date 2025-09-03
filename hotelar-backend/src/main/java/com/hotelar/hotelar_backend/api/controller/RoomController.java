package com.hotelar.hotelar_backend.api.controller;

import com.hotelar.hotelar_backend.api.dto.RoomDTO;
import com.hotelar.hotelar_backend.application.services.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("")
    public ResponseEntity<Object> getRooms(){
        return roomService.getRooms();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createRoom(@RequestBody @Valid RoomDTO roomDTO){
        return roomService.createRoom(roomDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable Long id){
        return roomService.deleteRoom(id);
    }
}
