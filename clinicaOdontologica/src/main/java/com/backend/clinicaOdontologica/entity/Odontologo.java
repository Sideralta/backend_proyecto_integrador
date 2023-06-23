package com.backend.clinicaOdontologica.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ODONTOLOGOS")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 10, message = "La matricula puede tener hasta 10 caracteres.")
    @NotNull(message = "La matricula no puede ser nula")
    @NotEmpty(message = "No puede estar vacio")
    private String numeroMatricula; //revisar cambiarlo por String

    @Size(max = 50, message = "El NOMBRE puede tener hasta 50 caracteres.")
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @Size(max = 50, message = "El apellido  puede tener hasta 50 caracteres.")
    @NotNull(message = "El apellido no puede ser nulo")
    private String apellido;

    public Odontologo() {
    }

    public Odontologo(String numeroMatricula, String nombre, String apellido) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }


    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
