package com.example.pia_poo_2026.model;

import java.io.Serializable;

public class Membresia implements Serializable {
    private String tipo; // basica, premium, vip
    private double precio;
    private String fechaInicio;
    private String fechaVencimiento;
    private boolean activa;
    private Cliente cliente;

    public Membresia(String tipo, double precio, String fechaInicio, String fechaVencimiento, Cliente cliente) {
        this.tipo = tipo;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.activa = true;
        this.cliente = cliente;
    }

    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }
    public String getFechaInicio() { return fechaInicio; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public boolean isActiva() { return activa; }
    public Cliente getCliente() { return cliente; }

    public void setActiva(boolean activa) { this.activa = activa; }
    public void setFechaVencimiento(String fecha) { this.fechaVencimiento = fecha; }

    @Override
    public String toString() {
        return tipo + " | " + cliente.getNombre() + " | Vence: " + fechaVencimiento + " | " + (activa ? "Activa" : "Vencida");
    }
}