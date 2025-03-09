package com.yr.alquilercoches.models.entities;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Alquileres")
public class Alquiler {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con la entidad Coche
    @ManyToOne
    @JoinColumn(name = "coche_id", nullable = false)
    private Coches coche;

    @Column(nullable = false, name = "fecha_inicio")
    @NotEmpty
    private String fecha_inicio;

    @Column(nullable = false, name = "fecha_fin")
    @NotEmpty
    private String fecha_fin;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes cliente;

    @Column(nullable = false, name = "precio_total")
    @NotEmpty
    @Digits(integer = 10, fraction = 2)
    private BigDecimal precio_total;

    public Alquiler() {
    }


    public Alquiler(Long id, Coches coche, String fecha_inicio, String fecha_fin, Clientes cliente, BigDecimal precio_total) {
        this.id = id;
        this.coche = coche;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.cliente = cliente;
        this.precio_total = precio_total;
    }


    @Override
    public String toString() {
        return "Alquileres{" +
                "id='" + this.id + '\'' +
                ", coche_id='" + coche + '\'' +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", fecha_fin='" + fecha_fin + '\'' +
                ", cliente_id='" + cliente + '\'' +
                ", precio_total='" + precio_total + '\'' +
                '}';
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coches getCoche() {
        return this.coche;
    }
    
    public void setCoche(Coches coche) {
        this.coche = coche;
    }

    public String getFecha_inicio() {
        return this.fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return this.fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    public Clientes getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getPrecio_total() {
        return this.precio_total;
    }

    public void setPrecio_total(BigDecimal precio_total) {
        this.precio_total = precio_total;
    }
    
}


