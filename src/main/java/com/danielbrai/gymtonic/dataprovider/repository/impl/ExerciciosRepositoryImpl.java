package com.danielbrai.gymtonic.dataprovider.repository.impl;

import com.danielbrai.gymtonic.core.model.Exercicio;
import com.danielbrai.gymtonic.dataprovider.model.ExercicioTable;
import com.danielbrai.gymtonic.dataprovider.repository.ExerciciosRepository;
import com.danielbrai.gymtonic.dataprovider.mapper.impl.ExercicioEntityToModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ExerciciosRepositoryImpl implements ExerciciosRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ExercicioEntityToModelMapper<ExercicioTable, Exercicio> exercicioEntityToModelMapper;

    @Override
    public List<Exercicio> listarExercicios() {
        List<ExercicioTable> resultadoBuscaExercicios = this.jdbcTemplate.query(
                """
                        SELECT
                            id as id,
                            nome as nome,
                            numero_series as numeroSeries,
                            carga as carga,
                            intervalo_segundos as intervaloSegundos,
                            numero_repeticoes as numeroRepeticoes
                        FROM
                            gym_tonic.exercicio;
                        """,
                new BeanPropertyRowMapper<>(ExercicioTable.class)
        );
        return resultadoBuscaExercicios.stream().map(this.exercicioEntityToModelMapper::traduzir).collect(Collectors.toList());
    }
}
