package com.estudospring.java_spring_webservices.database.repository;

import com.estudospring.java_spring_webservices.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// @Repository ->  pelo fato de extender JpaRepository não é necessario
public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity,Integer> {

    List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);
}
