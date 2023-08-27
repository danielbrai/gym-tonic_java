package com.danielbrai.gymtonic.core.domain;

import com.danielbrai.gymtonic.core.model.Exercicio;
import com.danielbrai.gymtonic.dataprovider.repository.ExerciciosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarExercicioUseCase {

    private ExerciciosRepository exerciciosRepository;

    public Exercicio execute(Exercicio exercicio) {
        Integer identificador = this.exerciciosRepository.criarExercicio(exercicio);
        exercicio.setId(identificador);
        return exercicio;
    }
}
