package com.danielbrai.gymtonic.dataprovider.repository;

import com.danielbrai.gymtonic.core.model.Exercicio;

import java.util.List;

public interface ExerciciosRepository {

    List<Exercicio> listarExercicios();
    Integer criarExercicio(Exercicio exercicio);
}
