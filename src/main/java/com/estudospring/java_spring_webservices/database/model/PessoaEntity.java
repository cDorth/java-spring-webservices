package com.estudospring.java_spring_webservices.database.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PessoaEntity {
    private Integer id;
    private String nome;
    private String email;
}
