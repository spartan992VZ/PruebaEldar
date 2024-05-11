CREATE TABLE IF NOT EXISTS TarjetaCredito (
    numero_tdc VARCHAR(20) PRIMARY KEY,
    marca VARCHAR(100),
    cardholder VARCHAR(100),
    fecha_vencimiento DATE
);