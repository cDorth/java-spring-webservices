package com.estudospring.java_spring_webservices.database.repository;

import com.estudospring.java_spring_webservices.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {
}
