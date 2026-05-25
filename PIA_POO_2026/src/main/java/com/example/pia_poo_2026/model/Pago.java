package com.example.pia_poo_2026.model;

import java.io.Serializable;

public class Pago implements Serializable {
    private double monto;
    private String fecha;
    private String concepto;
    private Cliente cliente;

    public Pago(double monto, String fecha, String concepto, Cliente cliente) {
        this.monto = monto;
        this.fecha = fecha;
        this.concepto = concepto;
        this.cliente = cliente;
    }

    public double getMonto() { return monto; }
    public String getFecha() { return fecha; }
    public String getConcepto() { return concepto; }
    public Cliente getCliente() { return cliente; }

    @Override
    public String toString() {
        return cliente.getNombre() + " | " + concepto + " | $" + monto + " | " + fecha;
    }
}