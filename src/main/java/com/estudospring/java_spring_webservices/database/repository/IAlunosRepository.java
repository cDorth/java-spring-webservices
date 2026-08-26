package com.estudospring.java_spring_webservices.database.repository;

import com.estudospring.java_spring_webservices.database.model.AlunosEntity;
import com.estudospring.java_spring_webservices.dto.AlunoDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunosEntity,Integer> {

    Optional<AlunosEntity> findByEmail(String email);
}
