// PagoController.java
package com.example.pia_poo_2026.controller;

import com.example.pia_poo_2026.exception.PagoInvalidoException;
import com.example.pia_poo_2026.model.Pago;
import com.example.pia_poo_2026.util.Serializador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class PagoController {
    private ObservableList<Pago> pagos = FXCollections.observableArrayList();
    private static final String ARCHIVO = "pagos.dat";

    public PagoController() {
        cargarDatos();
    }

    public void procesarPago(Pago p) throws PagoInvalidoException {
        if (p.getMonto() <= 0) {
            throw new PagoInvalidoException(p.getMonto());
        }
        p.getCliente().agregarPuntos((int) p.getMonto() / 10);
        pagos.add(p);
        guardarDatos();
    }

    public ObservableList<Pago> getPagos() { return pagos; }

    public double getTotalRecaudado() {
        return pagos.stream().mapToDouble(Pago::getMonto).sum();
    }

    private void guardarDatos() {
        Serializador.guardar(pagos.stream().collect(Collectors.toList()), ARCHIVO);
    }

    @SuppressWarnings("unchecked")
    private void cargarDatos() {
        List<Pago> lista = (List<Pago>) Serializador.cargar(ARCHIVO);
        if (lista != null) pagos.addAll(lista);
    }
}