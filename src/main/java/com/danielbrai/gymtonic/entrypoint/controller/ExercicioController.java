package com.danielbrai.gymtonic.entrypoint.controller;

import com.danielbrai.gymtonic.core.domain.CriarExercicioUseCase;
import com.danielbrai.gymtonic.core.domain.ListarExercicioUseCase;
import com.danielbrai.gymtonic.core.model.Exercicio;
import com.danielbrai.gymtonic.enablers.BaseMapper;
import com.danielbrai.gymtonic.entrypoint.model.ExercicioView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/exercicios")
@AllArgsConstructor
public class ExercicioController {

    private final BaseMapper<Exercicio, ExercicioView> exercicioToExercicioViewMapper;
    private final BaseMapper<ExercicioView, Exercicio> exercicioViewToExercicioMapper;
    private final ListarExercicioUseCase listarExercicioUseCase;
    private final CriarExercicioUseCase criarExercicioUseCase;

    @GetMapping("")
    public List<ExercicioView> listarTodos() {
        List<Exercicio> listaExercicios = this.listarExercicioUseCase.execute();
        return listaExercicios.stream().map(this.exercicioToExercicioViewMapper::traduzir).toList();
    }

    @PostMapping("")
    public ResponseEntity<ExercicioView> criarExercicio(@RequestBody ExercicioView exercicio) {
        Exercicio exercicioCriado = this.exercicioViewToExercicioMapper.traduzir(exercicio);
        exercicioCriado = this.criarExercicioUseCase.execute(exercicioCriado);
        ExercicioView exercicioCriadoViewModel = this.exercicioToExercicioViewMapper.traduzir(exercicioCriado);
        return ResponseEntity.ok(exercicioCriadoViewModel);
    }
}
