package com.example.pia_poo_2026.exception;

public class PagoInvalidoException extends GymException {
    private double montoPagado;

    public PagoInvalidoException(double monto) {
        super("Pago invalido. Monto: " + monto);
        this.montoPagado = monto;
    }

    public double getMontoPagado() { return montoPagado; }
}