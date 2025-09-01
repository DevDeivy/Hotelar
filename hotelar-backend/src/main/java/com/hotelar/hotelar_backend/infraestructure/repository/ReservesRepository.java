package com.hotelar.hotelar_backend.infraestructure.repository;

import com.hotelar.hotelar_backend.domain.models.Reserves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservesRepository extends JpaRepository<Reserves, Long> {

}
