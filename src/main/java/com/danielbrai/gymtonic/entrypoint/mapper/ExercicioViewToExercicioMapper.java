package com.danielbrai.gymtonic.entrypoint.mapper;

import com.danielbrai.gymtonic.core.model.Exercicio;
import com.danielbrai.gymtonic.enablers.BaseMapper;
import com.danielbrai.gymtonic.entrypoint.model.ExercicioView;
import org.springframework.stereotype.Component;

@Component
public class ExercicioViewToExercicioMapper<I,O> implements BaseMapper<ExercicioView, Exercicio> {
    @Override
    public Exercicio traduzir(ExercicioView input) {
        return Exercicio.builder()
                .id(input.getId())
                .carga(input.getCarga())
                .intervaloSegundos(input.getIntervaloSegundos())
                .numeroSeries(input.getNumeroSeries())
                .nome(input.getNome())
                .numeroRepeticoes(input.getNumeroRepeticoes())
                .build();
    }
}
