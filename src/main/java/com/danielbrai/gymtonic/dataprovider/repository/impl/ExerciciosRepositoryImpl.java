package com.danielbrai.gymtonic.dataprovider.repository.impl;

import com.danielbrai.gymtonic.core.model.Exercicio;
import com.danielbrai.gymtonic.dataprovider.model.ExercicioTable;
import com.danielbrai.gymtonic.dataprovider.repository.ExerciciosRepository;
import com.danielbrai.gymtonic.dataprovider.mapper.impl.ExercicioEntityToModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ExerciciosRepositoryImpl implements ExerciciosRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
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
                            exercicio
                        """,
                new BeanPropertyRowMapper<>(ExercicioTable.class)
        );
        return resultadoBuscaExercicios.stream().map(this.exercicioEntityToModelMapper::traduzir).collect(Collectors.toList());
    }

    @Override
    public Integer criarExercicio(Exercicio exercicio) {

        String instrucaoSql = """
                                
                INSERT INTO exercicio 
                (
                    nome,
                    numero_series,
                    carga,
                    intervalo_segundos,
                    numero_repeticoes
                )
                VALUES
                (
                    :nome,                    
                    :numero_series,
                    :carga,
                    :intervalo_segundos,
                    :numero_repeticoes
                )
        """;
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("nome", exercicio.getNome())
                .addValue("numero_series", exercicio.getNumeroSeries())
                .addValue("carga", exercicio.getCarga())
                .addValue("intervalo_segundos", exercicio.getIntervaloSegundos())
                .addValue("numero_repeticoes", exercicio.getNumeroRepeticoes());

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(instrucaoSql, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }
}
