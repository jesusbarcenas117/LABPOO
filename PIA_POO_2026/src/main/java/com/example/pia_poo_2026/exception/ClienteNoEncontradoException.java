package com.example.pia_poo_2026.exception;

public class ClienteNoEncontradoException extends GymException {
    public ClienteNoEncontradoException(String nombre) {
        super("Cliente no encontrado: " + nombre);
    }
}