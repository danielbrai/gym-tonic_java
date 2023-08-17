package com.danielbrai.gymtonic.core.domain;

import com.danielbrai.gymtonic.core.model.Exercicio;
import com.danielbrai.gymtonic.dataprovider.repository.ExerciciosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarExercicioUseCase {

    private final ExerciciosRepository exerciciosRepository;

    public List<Exercicio> execute() {
        return this.exerciciosRepository.listarExercicios();
    }

}
