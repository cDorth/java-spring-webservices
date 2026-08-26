package com.estudospring.java_spring_webservices.database.repository;

import com.estudospring.java_spring_webservices.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {

    Optional<TreinosEntity> findByNomeAndAlunoId(String nome, Integer alunoId);
}
