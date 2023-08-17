DROP TABLE IF EXISTS exercicio;
CREATE TABLE IF NOT EXISTS exercicio (
    id SERIAL PRIMARY KEY NOT NULL,
    nome VARCHAR(150) NOT NULL,
    numero_series SMALLINT NOT NULL,
    carga SMALLINT,
    intervalo_segundos SMALLINT NOT NULL,
    numero_repeticoes SMALLINT NOT NULL
);