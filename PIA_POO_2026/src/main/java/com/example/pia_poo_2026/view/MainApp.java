package com.example.pia_poo_2026.view;

import com.example.pia_poo_2026.controller.AccesoController;
import com.example.pia_poo_2026.controller.ClienteController;
import com.example.pia_poo_2026.controller.MembresiaController;
import com.example.pia_poo_2026.controller.PagoController;
import com.example.pia_poo_2026.exception.ClienteNoEncontradoException;
import com.example.pia_poo_2026.exception.MembresiaVencidaException;
import com.example.pia_poo_2026.exception.PagoInvalidoException;
import com.example.pia_poo_2026.model.Cliente;
import com.example.pia_poo_2026.model.Membresia;
import com.example.pia_poo_2026.model.Pago;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        ClienteController cc = new ClienteController();
        MembresiaController mc = new MembresiaController();
        PagoController pc = new PagoController();
        AccesoController ac = new AccesoController(mc);

        Cliente c1 = cc.getClientes().get(0);

        Membresia m1 = new Membresia("premium", 500, "2026-01-01", "2026-12-31", c1);
        mc.agregar(m1);

        try {
            Pago p1 = new Pago(500, "2026-05-24", "Mensualidad", c1);
            pc.procesarPago(p1);
            System.out.println("Pago procesado. Puntos: " + c1.getPuntos());

            Pago p2 = new Pago(-100, "2026-05-24", "Invalido", c1);
            pc.procesarPago(p2);
        } catch (PagoInvalidoException e) {
            System.out.println("Excepcion capturada: " + e.getMessage());
        }

        try {
            ac.registrarEntrada(c1, m1);
            ac.registrarSalida(c1);
        } catch (MembresiaVencidaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Total recaudado: $" + pc.getTotalRecaudado());
        System.out.println("Accesos registrados: " + ac.getAccesos().size());
    }
}
