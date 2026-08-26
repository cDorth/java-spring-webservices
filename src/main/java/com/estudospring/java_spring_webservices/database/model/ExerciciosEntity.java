package com.estudospring.java_spring_webservices.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercicios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ExerciciosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,name = "grupo_muscular")
    private String grupoMuscular;


}
