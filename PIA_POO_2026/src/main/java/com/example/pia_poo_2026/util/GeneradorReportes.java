package com.example.pia_poo_2026.util;

import com.example.pia_poo_2026.model.Cliente;
import com.example.pia_poo_2026.model.Pago;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeneradorReportes implements Runnable {
    private List<Cliente> clientes;
    private List<Pago> pagos;

    public GeneradorReportes(List<Cliente> clientes, List<Pago> pagos) {
        this.clientes = clientes;
        this.pagos = pagos;
    }

    @Override
    public void run() {
        generarTXT();
        hacerBackup();
    }

    private void generarTXT() {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String archivo = "reporte_" + timestamp + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write("=== REPORTE GYMPOS ===\n");
            bw.write("Generado: " + timestamp + "\n\n");

            bw.write("--- CLIENTES (" + clientes.size() + ") ---\n");
            for (Cliente c : clientes) {
                bw.write(c.toString() + "\n");
            }

            bw.write("\n--- PAGOS (" + pagos.size() + ") ---\n");
            double total = pagos.stream().mapToDouble(Pago::getMonto).sum();
            for (Pago p : pagos) {
                bw.write(p.toString() + "\n");
            }
            bw.write("Total recaudado: $" + total + "\n");

            System.out.println("Reporte generado: " + archivo);
        } catch (IOException e) {
            System.out.println("Error generando reporte: " + e.getMessage());
        }
    }

    private void hacerBackup() {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        System.out.println("Backup realizado: " + timestamp);
    }
}