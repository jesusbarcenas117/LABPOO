package com.example.pia_poo_2026.controller;
import java.util.stream.Collectors;
import com.example.pia_poo_2026.exception.ClienteNoEncontradoException;
import com.example.pia_poo_2026.model.Cliente;
import com.example.pia_poo_2026.util.Serializador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ClienteController {
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private static final String ARCHIVO = "clientes.dat";

    public ClienteController() {
        cargarDatos();
        if (clientes.isEmpty()) cargarDatosPrueba();
    }

    public void agregar(Cliente c) {
        clientes.add(c);
        guardarDatos();
    }

    public void eliminar(Cliente c) {
        clientes.remove(c);
        guardarDatos();
    }

    public void actualizar(Cliente original, Cliente nuevo) {
        int i = clientes.indexOf(original);
        if (i >= 0) {
            clientes.set(i, nuevo);
            guardarDatos();
        }
    }

    public Cliente buscar(String nombre) throws ClienteNoEncontradoException {
        return clientes.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new ClienteNoEncontradoException(nombre));
    }

    public ObservableList<Cliente> getClientes() { return clientes; }

    private void guardarDatos() {
        Serializador.guardar(clientes.stream().collect(Collectors.toList()), ARCHIVO);
    }

    @SuppressWarnings("unchecked")
    private void cargarDatos() {
        List<Cliente> lista = (List<Cliente>) Serializador.cargar(ARCHIVO);
        if (lista != null) clientes.addAll(lista);
    }

    private void cargarDatosPrueba() {
        clientes.addAll(
                new Cliente("Jesus", "Barcenas", "jesus@gym.com", "8110001111"),
                new Cliente("Daniel", "Lopez", "daniel@gym.com", "8112223333"),
                new Cliente("Maria", "Garcia", "maria@gym.com", "8114445555"),
                new Cliente("Pedro", "Ramirez", "pedro@gym.com", "8116667777"),
                new Cliente("Ana", "Torres", "ana@gym.com", "8118889999"),
                new Cliente("Carlos", "Mendez", "carlos@gym.com", "8110002222"),
                new Cliente("Laura", "Sanchez", "laura@gym.com", "8113334444"),
                new Cliente("Roberto", "Diaz", "roberto@gym.com", "8115556666"),
                new Cliente("Sofia", "Herrera", "sofia@gym.com", "8117778888"),
                new Cliente("Miguel", "Castro", "miguel@gym.com", "8119990000"),
                new Cliente("Elena", "Flores", "elena@gym.com", "8111112222"),
                new Cliente("Andres", "Reyes", "andres@gym.com", "8113334444"),
                new Cliente("Patricia", "Vega", "patricia@gym.com", "8115556666"),
                new Cliente("Fernando", "Luna", "fernando@gym.com", "8117778888"),
                new Cliente("Gabriela", "Mora", "gabriela@gym.com", "8119990000"),
                new Cliente("Ricardo", "Pena", "ricardo@gym.com", "8110001111"),
                new Cliente("Valentina", "Cruz", "valentina@gym.com", "8112223333"),
                new Cliente("Jorge", "Medina", "jorge@gym.com", "8114445555"),
                new Cliente("Claudia", "Rios", "claudia@gym.com", "8116667777"),
                new Cliente("Alberto", "Vargas", "alberto@gym.com", "8118889999")
        );
        guardarDatos();
    }
}