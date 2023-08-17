package com.danielbrai.gymtonic.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exercicio {

    private long id;
    private String nome;
    private byte numeroSeries;
    private byte numeroRepeticoes;
    private byte carga;
    private byte intervaloSegundos;
}
