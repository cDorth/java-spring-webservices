package com.estudospring.java_spring_webservices.service;

import com.estudospring.java_spring_webservices.database.model.AlunosEntity;
import com.estudospring.java_spring_webservices.database.model.ExerciciosEntity;
import com.estudospring.java_spring_webservices.database.model.TreinosEntity;
import com.estudospring.java_spring_webservices.database.repository.IAlunosRepository;
import com.estudospring.java_spring_webservices.database.repository.IExerciciosRepository;
import com.estudospring.java_spring_webservices.database.repository.ITreinosRepository;
import com.estudospring.java_spring_webservices.dto.TreinoDto;
import com.estudospring.java_spring_webservices.exception.BadRequestException;
import com.estudospring.java_spring_webservices.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinosService {

    private final ITreinosRepository treinosRepository;
    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;

    public void criarTreino(TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        Set<ExerciciosEntity> exercicios = new HashSet<>();
        AlunosEntity aluno = alunosRepository.findById(treinoDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Não existe aluno com este Id"));

        TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDto.getNome(),treinoDto.getAlunoId())
                .orElse(null);

        if (treino != null){
            throw new BadRequestException("Já possui um treino para este aluno");
        }

        for(Integer exercicioId : treinoDto.getExerciciosIds()){
            ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException(String.format("exercicio %s não encontrado",exercicioId)));

            exercicios.add(exercicio);
        }
        treino = TreinosEntity.builder()
                .nome(treinoDto.getNome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();

        treinosRepository.save(treino);

    }

}
