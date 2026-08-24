package com.estudospring.java_spring_webservices.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoDto {

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
