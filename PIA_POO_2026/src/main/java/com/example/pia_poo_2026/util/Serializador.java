package com.example.pia_poo_2026.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializador {

    public static void guardar(Object objeto, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
            System.out.println("Error guardando: " + e.getMessage());
        }
    }

    public static Object cargar(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Sin datos previos: " + archivo);
            return null;
        }
    }
}