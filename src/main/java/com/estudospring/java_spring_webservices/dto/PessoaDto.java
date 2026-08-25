package com.estudospring.java_spring_webservices.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PessoaDto {
    private String nome;
    private String email;
}
