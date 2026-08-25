package com.estudospring.java_spring_webservices.service;

import com.estudospring.java_spring_webservices.database.model.PessoaEntity;
import com.estudospring.java_spring_webservices.dto.PessoaDto;
import com.estudospring.java_spring_webservices.exception.ErrorResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {
    private static final List<PessoaEntity> PESSOAS = new ArrayList<>();

    static{
      PESSOAS.add(PessoaEntity.builder()
              .id(1)
              .nome("carlos")
              .email("carlos@gmail.com")
              .build());
      PESSOAS.add(PessoaEntity.builder()
              .id(2)
              .nome("pedro")
              .email("pedro@gmail.com")
              .build());

    }

    public List<PessoaEntity> findAll(){
        return new ArrayList<>(PESSOAS);
    }

    public PessoaEntity createPessoa(PessoaDto pessoaDto){
        Integer indentificador = PESSOAS.stream()
                .mapToInt(PessoaEntity::getId)
                .max()
                .orElse(0) + 1;

        PessoaEntity novaPessoa = PessoaEntity.builder()
                .id(indentificador)
                .nome(pessoaDto.getNome())
                .email(pessoaDto.getEmail())
                .build();
        PESSOAS.add(novaPessoa);

        return novaPessoa;
    }




}
