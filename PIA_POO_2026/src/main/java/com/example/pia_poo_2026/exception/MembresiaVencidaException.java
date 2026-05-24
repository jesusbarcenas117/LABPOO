package com.example.pia_poo_2026.exception;

public class MembresiaVencidaException extends GymException {
    public MembresiaVencidaException(String nombreCliente) {
        super("Membresia vencida para: " + nombreCliente);
    }
}