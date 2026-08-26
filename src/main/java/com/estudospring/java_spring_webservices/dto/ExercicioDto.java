package com.estudospring.java_spring_webservices.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ExercicioDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String grupoMuscular;

}
