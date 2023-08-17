DROP DATABASE gym_tonic_db;
CREATE DATABASE gym_tonic_db
WITH OWNER = postgres
   ENCODING = 'UTF8'
   TABLESPACE = pg_default
   LC_COLLATE = 'pt_BR.UTF-8'
   CONNECTION LIMIT = -1
   TEMPLATE template0;
SET search_path TO gym_tonic_db;
);