package com.danielbrai.gymtonic.dataprovider.mapper.impl;

import com.danielbrai.gymtonic.core.model.Exercicio;
import com.danielbrai.gymtonic.dataprovider.model.ExercicioTable;
import com.danielbrai.gymtonic.enablers.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ExercicioEntityToModelMapper<I, O> implements BaseMapper<ExercicioTable, Exercicio> {
    @Override
    public Exercicio traduzir(ExercicioTable input) {
        return Exercicio.builder()
                .nome(input.getNome())
                .id(Objects.nonNull(input.getId()) ? input.getId() : 0)
                .carga(Objects.nonNull(input.getCarga()) ? input.getCarga() : 0)
                .intervaloSegundos(Objects.nonNull(input.getIntervaloSegundos()) ? input.getIntervaloSegundos() : 0)
                .numeroSeries(Objects.nonNull(input.getNumeroSeries()) ? input.getNumeroSeries() : 0)
                .numeroRepeticoes(Objects.nonNull(input.getNumeroRepeticoes()) ? input.getNumeroRepeticoes() : 0)
                .build();
    }
}
