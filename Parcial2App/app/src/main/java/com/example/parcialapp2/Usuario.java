package com.example.parcialapp2;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String imagen;

    private String nombre;

    private String profesion;

    private String apodo;

    public Usuario(String imagen, String nombre, String profesion, String apodo) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.profesion = profesion;
        this.apodo = apodo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
}