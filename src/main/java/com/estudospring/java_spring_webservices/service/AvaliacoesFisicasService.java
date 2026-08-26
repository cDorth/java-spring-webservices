package com.estudospring.java_spring_webservices.service;

import com.estudospring.java_spring_webservices.database.model.AlunosEntity;
import com.estudospring.java_spring_webservices.database.model.AvaliacoesFisicasEntity;
import com.estudospring.java_spring_webservices.database.repository.IAlunosRepository;
import com.estudospring.java_spring_webservices.database.repository.IAvaliacoesFisicasRepository;
import com.estudospring.java_spring_webservices.dto.AvaliacaoFisicaDto;
import com.estudospring.java_spring_webservices.exception.BadRequestException;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacoesFisicasService {
    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;


    // verificar se o melhor jeito de salvar o elemento é injetando pelo responsavel. @OneToOne
    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException,BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacoesFisicasEntity avaliacaoFisica = aluno.getAvaliacoesFisicas();
        if (avaliacaoFisica != null){
            throw new BadRequestException("Avaliação fisica já cadastrada neste aluno!");
        }

        avaliacaoFisica = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPorcentagemGorduraCorporal())
                .build();

        aluno.setAvaliacoesFisicas(avaliacaoFisica);
        alunosRepository.save(aluno);
    }

}
