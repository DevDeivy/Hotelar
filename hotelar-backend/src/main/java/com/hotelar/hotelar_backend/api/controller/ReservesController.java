package com.hotelar.hotelar_backend.api.controller;

import com.hotelar.hotelar_backend.api.dto.ReservesDTO;
import com.hotelar.hotelar_backend.application.services.ReservesServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserves")
@RequiredArgsConstructor
public class ReservesController {

    private final ReservesServices reservesServices;

    @PostMapping("/create")
    public ResponseEntity<Object> createReserve(@RequestBody @Valid ReservesDTO reservesDTO){
        return reservesServices.createReserve(reservesDTO);
    }

    @PostMapping("/")

}
