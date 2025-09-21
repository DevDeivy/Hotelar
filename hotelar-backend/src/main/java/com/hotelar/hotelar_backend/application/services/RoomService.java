package com.hotelar.hotelar_backend.application.services;

import com.hotelar.hotelar_backend.api.dto.RoomDTO;
import com.hotelar.hotelar_backend.domain.models.Room;
import com.hotelar.hotelar_backend.infraestructure.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public ResponseEntity<Object> getRooms(){
        return ResponseEntity.status(HttpStatus.FOUND).body(roomRepository.findAll());
    }

    public Room createRoom(@RequestBody RoomDTO roomDTO){
        Set<String> includeState = Set.of("disponible", "ocupado", "fuera de servicio");
        Room room = roomDTOtoRoom(roomDTO);
        if(roomRepository.existsByRoomNumber(roomDTO.getRoomNumber())){
            throw new IllegalArgumentException();
        }
        /*String state = (roomDTO.getStateRoom() == null || roomDTO.getStateRoom().isBlank()) ? "disponible" : roomDTO.getStateRoom().toLowerCase();

        if (!includeState.contains(state)) {
            throw new IllegalArgumentException("invalid state");
        }*/

        Room savedRoom = roomRepository.save(room);
        roomDTO.setId(savedRoom.getId());

        return savedRoom;
    }

    private Room roomDTOtoRoom(RoomDTO roomDTO){
        Room room = new Room();
        room.setTypeRoom(roomDTO.getTypeRoom());
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setStateRoom(roomDTO.getStateRoom());
        room.setPriceRoom(roomDTO.getPriceRoom());
        return room;
    }

    public ResponseEntity<Object> deleteRoom(Long id){
        if(!roomRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("this room don´t exist");
        }
        roomRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Room deleted");
    }
}
