package com.hotelar.hotelar_backend.infraestructure.repository;

import com.hotelar.hotelar_backend.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existByEmail(String email);
}
