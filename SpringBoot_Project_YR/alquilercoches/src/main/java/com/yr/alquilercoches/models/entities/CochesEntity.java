package com.yr.alquilercoches.models.entities;

import jakarta.persistence.Entity;

@Entity
public class CochesEntity {
    

}
/*Crear la tabla de Coches
sql
CREATE TABLE Coches (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    año INT NOT NULL,
    color VARCHAR(30),
    precio DECIMAL(10, 2)
);*/ 