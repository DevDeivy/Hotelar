package com.hotelar.hotelar_backend.application.services;

import com.hotelar.hotelar_backend.api.dto.ReservesDTO;
import com.hotelar.hotelar_backend.domain.models.Reserves;
import com.hotelar.hotelar_backend.infraestructure.repository.ReservesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservesServices {

    private final ReservesRepository reservesRepository;

    public ResponseEntity<Object> createReserve(@RequestBody ReservesDTO reservesDTO){
        Reserves reserves = new Reserves();
        LocalDateTime localDateTime = LocalDateTime.now();
        if(reservesRepository.existsById(reserves.getId())){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("the id exist");
        }
        reserves.setStartDate(localDateTime);
        //reserves.setFinishDate(finishDate()); //buscar la mejor manera de saber la fecha de caducación
        reserves.setState(reservesDTO.getState());
        reservesRepository.save(reserves);
        return ResponseEntity.ok().body("");
    }

    /*
    private LocalDateTime plusDays(Long days){
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        LocalDateTime plusDays = localDateTimeNow.plusDays(days);
        return plusDays;
    }

    private LocalDateTime plusHours(Long hours){
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        LocalDateTime plusHours = localDateTimeNow.plusHours(hours);
        return plusHours;
    }*/

    //otra opcion que he pensado es pasar el numero de horas o dias por parametro,
    // capturar la variable junto con el ReserveDTO en el controlador

}


















