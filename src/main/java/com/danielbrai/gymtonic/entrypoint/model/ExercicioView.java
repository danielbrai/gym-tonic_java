package com.danielbrai.gymtonic.entrypoint.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExercicioView implements Serializable {

    private long id;
    private String nome;
    private byte numeroSeries;
    private byte numeroRepeticoes;
    private byte carga;
    private byte intervaloSegundos;
}
