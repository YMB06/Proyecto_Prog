package com.yr.alquilercoches.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Clientes {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String nombre;

        @Column(nullable = false)
        private String apellidos;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String telefono;

        @Column(nullable = false, unique = true)
        private String dni;

        // Getters y Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        // toString
        @Override
        public String toString() {
            return "Cliente{" +
                    "id=" + id +
                    ", nombre='" + nombre + '\'' +
                    ", apellidos='" + apellidos + '\'' +
                    ", email='" + email + '\'' +
                    ", telefono='" + telefono + '\'' +
                    ", dni='" + dni + '\'' +
                    '}';
        }

        //contructores
        public Clientes() {
        }

        public Clientes(Long id, String nombre, String apellidos, String email, String telefono, String dni) {
            this.id = id;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.email = email;
            this.telefono = telefono;
            this.dni = dni;
        }
    }
