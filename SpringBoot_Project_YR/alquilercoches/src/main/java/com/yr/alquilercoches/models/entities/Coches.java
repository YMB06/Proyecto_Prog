package com.yr.alquilercoches.models.entities;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Coches")
public class Coches {
    

    @Id
    private String id;

    @Column(nullable = false, name = "marca")
    @NotEmpty
    private String marca;

    @Column(nullable = false, name = "modelo")
    @NotEmpty
    private String modelo;

    @Column(nullable = false, name = "año")
    @NotEmpty
    private int año;

    @Column(nullable = false, name = "color")
    @NotEmpty
    private String color;

    @Column(nullable = false, name = "precio")
    @NotEmpty
    @Digits(integer = 10, fraction = 2)
    private BigDecimal precio;

    public Coches() {
    }


    public Coches(String id, String marca, String modelo, int año, String color, BigDecimal precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "Coches{" +
                "id='" + this.id + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año='" + año + '\'' +
                ", color='" + color + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return this.año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrecio() {
        return this.precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }


}
