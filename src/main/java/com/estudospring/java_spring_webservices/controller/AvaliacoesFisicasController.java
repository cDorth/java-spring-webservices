package com.estudospring.java_spring_webservices.controller;

import com.estudospring.java_spring_webservices.dto.AvaliacaoFisicaDto;
import com.estudospring.java_spring_webservices.dto.AvaliacoesFisicasProjection;
import com.estudospring.java_spring_webservices.exception.BadRequestException;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import com.estudospring.java_spring_webservices.service.AvaliacoesFisicasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacoesFisicasProjection> getAllAvaliacoes(){
        return avaliacoesFisicasService.getAllAvaliacoes();
    }

    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public Page<AvaliacoesFisicasProjection> getAllAvaliacoesPageable(@PathVariable Integer page,
                                                                      @PathVariable Integer size){
        return avaliacoesFisicasService.getAllAvaliacoesPageable(page, size);
    }
}

