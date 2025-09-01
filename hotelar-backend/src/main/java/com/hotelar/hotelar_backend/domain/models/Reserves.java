package com.hotelar.hotelar_backend.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_reserves")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserves {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "finishDate")
    private LocalDateTime finishDate;

    @Column(name = "state")
    private String state;
}
