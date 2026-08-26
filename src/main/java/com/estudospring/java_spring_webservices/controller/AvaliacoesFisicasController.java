package com.estudospring.java_spring_webservices.controller;

import com.estudospring.java_spring_webservices.dto.AvaliacaoFisicaDto;
import com.estudospring.java_spring_webservices.exception.BadRequestException;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import com.estudospring.java_spring_webservices.service.AvaliacoesFisicasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
@Validated
public class AvaliacoesFisicasController {
    private final AvaliacoesFisicasService avaliacoesFisicasService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacoesFisicasService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }
}
