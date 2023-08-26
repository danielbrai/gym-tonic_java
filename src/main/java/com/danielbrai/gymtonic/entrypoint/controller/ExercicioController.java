package com.danielbrai.gymtonic.entrypoint.controller;

import com.danielbrai.gymtonic.core.domain.ListarExercicioUseCase;
import com.danielbrai.gymtonic.core.model.Exercicio;
import com.danielbrai.gymtonic.entrypoint.mapper.ExercicioToExercicioViewMapper;
import com.danielbrai.gymtonic.entrypoint.model.ExercicioView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/exercicios")
@AllArgsConstructor
public class ExercicioController {

    private final ExercicioToExercicioViewMapper<Exercicio, ExercicioView> exercicioToExercicioViewMapper;
    private final ListarExercicioUseCase listarExercicioUseCase;

    @GetMapping("")
    public List<ExercicioView> listarTodos() {
        List<Exercicio> listaExercicios = this.listarExercicioUseCase.execute();
        return listaExercicios.stream().map(this.exercicioToExercicioViewMapper::traduzir).collect(Collectors.toList());
    }
}
