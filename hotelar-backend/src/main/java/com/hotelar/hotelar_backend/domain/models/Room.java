package com.hotelar.hotelar_backend.domain.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tbl_room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "roomNumber", nullable = false, unique = true)
    private String roomNumber;

    @Column(name = "type_room", nullable = false)
    private String typeRoom;

    @Column(name = "priceRoom", nullable = false)
    private Integer priceRoom;

    @Column(name = "stateRoom", nullable = false)
    private String stateRoom;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Reserves> reserves;

}
