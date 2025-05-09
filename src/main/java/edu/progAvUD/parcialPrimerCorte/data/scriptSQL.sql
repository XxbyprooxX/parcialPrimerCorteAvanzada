CREATE DATABASE IF NOT EXISTS datosGatos;

USE datosGatos;

CREATE TABLE IF NOT EXISTS gatos (
    nombreRaza VARCHAR(35) ,
    codigoEMS VARCHAR(20),
    colorCuerpo VARCHAR(35),
    patron VARCHAR(35),
    colorOjos VARCHAR(35),
    cola VARCHAR(35),
);