package com.example.pia_poo_2026.exception;

public class GymException extends Exception {
    private String timestamp;

    public GymException(String mensaje) {
        super(mensaje);
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getTimestamp() { return timestamp; }
}