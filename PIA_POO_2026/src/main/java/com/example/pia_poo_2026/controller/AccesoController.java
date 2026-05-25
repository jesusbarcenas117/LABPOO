// AccesoController.java
package com.example.pia_poo_2026.controller;

import com.example.pia_poo_2026.exception.MembresiaVencidaException;
import com.example.pia_poo_2026.model.AccesoGimnasio;
import com.example.pia_poo_2026.model.Cliente;
import com.example.pia_poo_2026.model.Membresia;
import com.example.pia_poo_2026.util.Serializador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AccesoController {
    private ObservableList<AccesoGimnasio> accesos = FXCollections.observableArrayList();
    private static final String ARCHIVO = "accesos.dat";
    private MembresiaController membresiaController;

    public AccesoController(MembresiaController mc) {
        this.membresiaController = mc;
        cargarDatos();
    }

    public void registrarEntrada(Cliente cliente, Membresia membresia) throws MembresiaVencidaException {
        membresiaController.verificarVigencia(membresia);
        AccesoGimnasio acceso = new AccesoGimnasio(cliente, LocalDateTime.now().toString());
        accesos.add(acceso);
        guardarDatos();
        System.out.println("Entrada registrada: " + cliente.getNombre());
    }

    public void registrarSalida(Cliente cliente) {
        accesos.stream()
                .filter(a -> a.getCliente().getNombre().equals(cliente.getNombre()) && a.getFechaSalida() == null)
                .findFirst()
                .ifPresent(a -> {
                    a.setFechaSalida(LocalDateTime.now().toString());
                    guardarDatos();
                    System.out.println("Salida registrada: " + cliente.getNombre());
                });
    }

    public ObservableList<AccesoGimnasio> getAccesos() { return accesos; }

    private void guardarDatos() {
        Serializador.guardar(accesos.stream().collect(Collectors.toList()), ARCHIVO);
    }

    @SuppressWarnings("unchecked")
    private void cargarDatos() {
        List<AccesoGimnasio> lista = (List<AccesoGimnasio>) Serializador.cargar(ARCHIVO);
        if (lista != null) accesos.addAll(lista);
    }
}