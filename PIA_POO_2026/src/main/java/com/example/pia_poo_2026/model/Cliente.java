package com.example.pia_poo_2026.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String membresia; // basica, premium, vip

    public Cliente(String nombre, String apellido, String email, String telefono, String membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.membresia = membresia;
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
    public String getMembresia() {
        return membresia;
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
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " | " + membresia + " | " + email;
    }
}