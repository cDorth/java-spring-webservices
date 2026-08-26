package com.estudospring.java_spring_webservices.controller;

import com.estudospring.java_spring_webservices.database.model.AvaliacoesFisicasEntity;
import com.estudospring.java_spring_webservices.dto.AlunoDto;
import com.estudospring.java_spring_webservices.exception.BadRequestException;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import com.estudospring.java_spring_webservices.service.AlunosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {
    private final AlunosService alunosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) throws BadRequestException {
        alunosService.criarAluno(alunoDto);
    }

    @GetMapping("/{alunoId}/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacoesFisicasEntity getAlunoAvaliacao(@PathVariable Integer alunoId) throws NotFoundException {
        return alunosService.getAlunoAvaliacao(alunoId);
    }
}
