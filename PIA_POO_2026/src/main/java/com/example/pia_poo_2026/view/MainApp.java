package com.example.pia_poo_2026.view;

import com.example.pia_poo_2026.controller.ClienteController;
import com.example.pia_poo_2026.exception.ClienteNoEncontradoException;
import com.example.pia_poo_2026.model.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        ClienteController cc = new ClienteController();
        System.out.println("Clientes: " + cc.getClientes().size());

        try {
            Cliente encontrado = cc.buscar("Jesus"); // probando buscador
            System.out.println("Encontrado: " + encontrado);
        } catch (ClienteNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        try {
            cc.buscar("Fantasma");
        } catch (ClienteNoEncontradoException e) { //probando buscador con excepciones, falta implementar todos los controladores del crud
            System.out.println("Excepcion capturada: " + e.getMessage());
        }
    }
}
