package com.danielbrai.gymtonic.dataprovider.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExercicioTable {

    private Long id;
    private String nome;
    private Byte numeroSeries;
    private Byte numeroRepeticoes;
    private Byte carga;
    private Byte intervaloSegundos;
}
