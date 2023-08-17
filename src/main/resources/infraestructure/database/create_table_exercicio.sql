CREATE TABLE IF NOT EXISTS exercicio (
    id SERIAL PRIMARY KEY,
    nome varchar(150),
    numero_series smallint,
    carga smallint,
    intervalo_segundos smallint
    );