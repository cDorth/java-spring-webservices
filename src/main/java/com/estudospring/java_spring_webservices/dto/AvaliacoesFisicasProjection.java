package com.estudospring.java_spring_webservices.dto;

import java.math.BigDecimal;

public interface AvaliacoesFisicasProjection {
        Integer getIdAluno();
        String getNomeAluno();
        Integer getIdAvaliacao();
        BigDecimal getPeso();
        BigDecimal getAltura();
        BigDecimal getPorcentagemGorduraCorporal();

    }

