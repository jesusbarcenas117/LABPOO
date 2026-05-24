package com.example.practica_11_2026;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private static final String ARCHIVO = "clientes.dat";

    public ClienteController() {
        cargarDatos();
        if (clientes.isEmpty()) {
            cargarDatosPrueba();
        }
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
        int index = clientes.indexOf(original);
        if (index >= 0) {
            clientes.set(index, nuevo);
            guardarDatos();
        }
    }

    public ObservableList<Cliente> getClientes() {
        return clientes;
    }

    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(new ArrayList<>(clientes));
        } catch (IOException e) {
            System.out.println("Error guardando: " + e.getMessage());
        }
    }

    private void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            List<Cliente> lista = (List<Cliente>) ois.readObject();
            clientes.addAll(lista);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Sin datos previos.");
        }
    }

    private void cargarDatosPrueba() {
        clientes.addAll(
                new Cliente("Jesus", "Barcenas", "jesus@gym.com", "8110001111", "premium"),
                new Cliente("Daniel", "Lopez", "daniel@gym.com", "8112223333", "basica"),
                new Cliente("Maria", "Garcia", "maria@gym.com", "8114445555", "vip"),
                new Cliente("Pedro", "Ramirez", "pedro@gym.com", "8116667777", "basica"),
                new Cliente("Ana", "Torres", "ana@gym.com", "8118889999", "premium"),
                new Cliente("Carlos", "Mendez", "carlos@gym.com", "8110002222", "vip"),
                new Cliente("Laura", "Sanchez", "laura@gym.com", "8113334444", "basica"),
                new Cliente("Roberto", "Diaz", "roberto@gym.com", "8115556666", "premium"),
                new Cliente("Sofia", "Herrera", "sofia@gym.com", "8117778888", "vip"),
                new Cliente("Miguel", "Castro", "miguel@gym.com", "8119990000", "basica"),
                new Cliente("Elena", "Flores", "elena@gym.com", "8111112222", "premium"),
                new Cliente("Andres", "Reyes", "andres@gym.com", "8113334444", "vip"),
                new Cliente("Patricia", "Vega", "patricia@gym.com", "8115556666", "basica"),
                new Cliente("Fernando", "Luna", "fernando@gym.com", "8117778888", "premium"),
                new Cliente("Gabriela", "Mora", "gabriela@gym.com", "8119990000", "vip"),
                new Cliente("Ricardo", "Pena", "ricardo@gym.com", "8110001111", "basica"),
                new Cliente("Valentina", "Cruz", "valentina@gym.com", "8112223333", "premium"),
                new Cliente("Jorge", "Medina", "jorge@gym.com", "8114445555", "vip"),
                new Cliente("Claudia", "Rios", "claudia@gym.com", "8116667777", "basica"),
                new Cliente("Alberto", "Vargas", "alberto@gym.com", "8118889999", "premium")
        );
        guardarDatos();
    }
}