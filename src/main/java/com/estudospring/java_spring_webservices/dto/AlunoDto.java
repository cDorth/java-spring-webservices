package com.estudospring.java_spring_webservices.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class AlunoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;

}
