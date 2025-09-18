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
        return ResponseEntity.ok(roomRepository.findAll());
    }

    public ResponseEntity<Object> createRoom(@RequestBody RoomDTO roomDTO){
        Room room = new Room();
        Set<String> includeState = Set.of("disponible", "ocupado", "fuera de servicio");
        var state = roomDTO.getStateRoom().toLowerCase();
        if(roomRepository.existsByNumber(roomDTO.getNumber())){
            return ResponseEntity.badRequest().body("la habitacion ya existe");
        }else if(includeState.contains(state)){
            room.setStateRoom(state);
        } else {
            return ResponseEntity.badRequest().body("estado invalido");
        }
        room.setNumber(roomDTO.getNumber());
        room.setTypeRoom(roomDTO.getTypeRoom());
        roomRepository.save(room);

        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

    public ResponseEntity<Object> deleteRoom(Long id){
        if(!roomRepository.existsById(id)){
            return ResponseEntity.badRequest().body("el id no existe");
        }
        roomRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Room deleted");
    }
}
