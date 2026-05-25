package com.example.pia_poo_2026.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int puntos;

    public Cliente(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.puntos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMembresia(String membresia) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " | " + email + " | Puntos: " + puntos;
    }
}