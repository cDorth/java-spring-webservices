package com.estudospring.java_spring_webservices.service;

import com.estudospring.java_spring_webservices.database.model.AlunosEntity;
import com.estudospring.java_spring_webservices.database.model.AvaliacoesFisicasEntity;
import com.estudospring.java_spring_webservices.database.repository.IAlunosRepository;
import com.estudospring.java_spring_webservices.dto.AlunoDto;
import com.estudospring.java_spring_webservices.exception.BadRequestException;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunosService {

    private final IAlunosRepository alunosRepository;

    public void criarAluno(AlunoDto alunoDto) throws BadRequestException{
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDto.getEmail())
                .orElse(null);

        if (aluno != null){
            throw new BadRequestException("Aluno já cadastrado com este email!");
        }

        alunosRepository.save(AlunosEntity.builder()
                .nome(alunoDto.getNome())
                .email(alunoDto.getEmail())
                .build());

    }

    public AvaliacoesFisicasEntity getAlunoAvaliacao(Integer alunoId) throws NotFoundException {
        AlunosEntity aluno = alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Não existe aluno com este id!"));

        AvaliacoesFisicasEntity avaliacao = aluno.getAvaliacoesFisicas();

        if (avaliacao == null){
        throw new NotFoundException("Este aluno não possui uma avaliação");
        }

        return avaliacao;
    }
}
