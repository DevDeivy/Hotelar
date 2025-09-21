package com.hotelar.hotelar_backend.infraestructure.repository;

import com.hotelar.hotelar_backend.domain.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByRoomNumber(String roomNumber);
    Optional<Room> findByRoomNumber(String roomNumber);
}
