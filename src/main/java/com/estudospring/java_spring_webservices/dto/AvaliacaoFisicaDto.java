package com.estudospring.java_spring_webservices.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoFisicaDto {
    @NotNull
    private Integer alunoId;
    @NotNull
    private BigDecimal peso;
    @NotNull
    private BigDecimal altura;
    @NotNull
    private BigDecimal porcentagemGorduraCorporal;
}
