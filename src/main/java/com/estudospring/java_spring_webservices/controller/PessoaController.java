package com.estudospring.java_spring_webservices.controller;

import com.estudospring.java_spring_webservices.database.model.PessoaEntity;
import com.estudospring.java_spring_webservices.dto.PessoaDto;
import com.estudospring.java_spring_webservices.service.PessoaService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PessoaEntity> findAll(){
        return pessoaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaEntity createPessoa(@RequestBody PessoaDto pessoaDto){
        return pessoaService.createPessoa(pessoaDto);
    }

}
