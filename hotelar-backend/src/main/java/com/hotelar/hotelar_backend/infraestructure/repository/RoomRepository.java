package com.hotelar.hotelar_backend.infraestructure.repository;

import com.hotelar.hotelar_backend.domain.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByNumber(String number);
}
