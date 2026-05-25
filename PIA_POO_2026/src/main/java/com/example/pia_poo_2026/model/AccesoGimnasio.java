package com.example.pia_poo_2026.model;

import java.io.Serializable;

public class AccesoGimnasio implements Serializable {
    private Cliente cliente;
    private String fechaEntrada;
    private String fechaSalida;

    public AccesoGimnasio(Cliente cliente, String fechaEntrada) {
        this.cliente = cliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = null;
    }

    public Cliente getCliente() { return cliente; }
    public String getFechaEntrada() { return fechaEntrada; }
    public String getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(String fechaSalida) { this.fechaSalida = fechaSalida; }

    @Override
    public String toString() {
        return cliente.getNombre() + " | Entrada: " + fechaEntrada + " | Salida: " + (fechaSalida != null ? fechaSalida : "En gimnasio");
    }
}