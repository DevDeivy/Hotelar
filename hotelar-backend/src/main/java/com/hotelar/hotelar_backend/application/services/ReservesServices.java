package com.hotelar.hotelar_backend.application.services;

import com.hotelar.hotelar_backend.api.dto.ReservesDTO;
import com.hotelar.hotelar_backend.domain.models.Reserves;
import com.hotelar.hotelar_backend.domain.models.Room;
import com.hotelar.hotelar_backend.infraestructure.repository.ReservesRepository;
import com.hotelar.hotelar_backend.infraestructure.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class ReservesServices {

    private final ReservesRepository reservesRepository;
    private final RoomRepository roomRepository;

    public ResponseEntity<Object> createReserve(@RequestBody ReservesDTO reservesDTO){

        Reserves reserves = reserveDTOtoReserve(reservesDTO);
        reservesRepository.save(reserves);
        Room room = reserves.getRoom();
        room.setStateRoom(reserves.getState());
        roomRepository.save(room);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body("reserved successfully");
    }

    private Reserves reserveDTOtoReserve(ReservesDTO reservesDTO){

        Reserves reserves = new Reserves();
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime finishDate = startDate.plusDays(reservesDTO.getDays());
        reserves.setStartDate(startDate);
        reserves.setFinishDate(finishDate);
        Room room = roomRepository.findById(reservesDTO.getRoomId())
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        reserves.setRoom(room);

        LocalDateTime now = LocalDateTime.now();

        long diffDays = ChronoUnit.DAYS.between(now, finishDate);
        if (diffDays == 0) {
            reserves.setState("Disponible");
        } else if (diffDays > 0) {
            reserves.setState("Ocupado");
        } else {
            reserves.setState("Fuera de servicio");
        }

        System.out.println(diffDays);
        System.out.println(reserves.getState());
        System.out.println(finishDate);
        return reserves;
    }
}


















