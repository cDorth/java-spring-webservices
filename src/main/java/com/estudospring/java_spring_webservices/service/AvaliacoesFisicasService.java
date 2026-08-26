package com.estudospring.java_spring_webservices.service;

import com.estudospring.java_spring_webservices.database.model.AlunosEntity;
import com.estudospring.java_spring_webservices.database.model.AvaliacoesFisicasEntity;
import com.estudospring.java_spring_webservices.database.repository.IAlunosRepository;
import com.estudospring.java_spring_webservices.database.repository.IAvaliacoesFisicasRepository;
import com.estudospring.java_spring_webservices.dto.AvaliacaoFisicaDto;
import com.estudospring.java_spring_webservices.dto.AvaliacoesFisicasProjection;
import com.estudospring.java_spring_webservices.exception.BadRequestException;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



import java.util.List;

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

    public List<AvaliacoesFisicasProjection> getAllAvaliacoes(){
        return avaliacoesFisicasRepository.getAllAvaliacoes();
    }

    public Page<AvaliacoesFisicasProjection> getAllAvaliacoesPageable(Integer page, Integer size){
        return avaliacoesFisicasRepository.getAllAvaliacoesPageable(PageRequest.of(page, size));
    }

}
