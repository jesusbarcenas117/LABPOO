package com.example.pia_poo_2026.controller;

import com.example.pia_poo_2026.exception.MembresiaVencidaException;
import com.example.pia_poo_2026.model.Cliente;
import com.example.pia_poo_2026.model.Membresia;
import com.example.pia_poo_2026.util.Serializador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class MembresiaController {
    private ObservableList<Membresia> membresias = FXCollections.observableArrayList();
    private static final String ARCHIVO = "membresias.dat";

    public MembresiaController() {
        cargarDatos();
    }

    public void agregar(Membresia m) {
        membresias.add(m);
        guardarDatos();
    }

    public void renovar(Membresia m, String nuevaFecha) {
        m.setFechaVencimiento(nuevaFecha);
        m.setActiva(true);
        guardarDatos();
    }

    public void verificarVigencia(Membresia m) throws MembresiaVencidaException {
        if (!m.isActiva()) {
            throw new MembresiaVencidaException(m.getCliente().getNombre());
        }
    }

    public ObservableList<Membresia> getMembresias() { return membresias; }

    private void guardarDatos() {
        Serializador.guardar(membresias.stream().collect(Collectors.toList()), ARCHIVO);
    }

    @SuppressWarnings("unchecked")
    private void cargarDatos() {
        List<Membresia> lista = (List<Membresia>) Serializador.cargar(ARCHIVO);
        if (lista != null) membresias.addAll(lista);
    }
}