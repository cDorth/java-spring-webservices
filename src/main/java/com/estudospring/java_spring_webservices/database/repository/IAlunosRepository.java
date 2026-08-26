package com.estudospring.java_spring_webservices.database.repository;

import com.estudospring.java_spring_webservices.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunosRepository extends JpaRepository<AlunosEntity,Integer> {
}
