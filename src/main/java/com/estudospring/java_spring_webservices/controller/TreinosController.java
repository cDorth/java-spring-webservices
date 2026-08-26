package com.estudospring.java_spring_webservices.controller;

import com.estudospring.java_spring_webservices.dto.TreinoDto;
import com.estudospring.java_spring_webservices.exception.BadRequestException;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import com.estudospring.java_spring_webservices.service.TreinosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/v1/treinos")
public class TreinosController {

    private final TreinosService treinosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        treinosService.criarTreino(treinoDto);
    }
}
