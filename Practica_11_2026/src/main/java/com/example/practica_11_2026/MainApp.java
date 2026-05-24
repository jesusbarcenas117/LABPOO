package com.example.practica_11_2026;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ClienteController controller = new ClienteController();
    private TableView<Cliente> tabla = new TableView<>();

    @Override
    public void start(Stage stage) {
        TableColumn<Cliente, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getNombre()));

        TableColumn<Cliente, String> colApellido = new TableColumn<>("Apellido");
        colApellido.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getApellido()));

        TableColumn<Cliente, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));

        TableColumn<Cliente, String> colTelefono = new TableColumn<>("Telefono");
        colTelefono.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getTelefono()));

        TableColumn<Cliente, String> colMembresia = new TableColumn<>("Membresia");
        colMembresia.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getMembresia()));

        tabla.getColumns().addAll(colNombre, colApellido, colEmail, colTelefono, colMembresia);

        FilteredList<Cliente> filtrados = new FilteredList<>(controller.getClientes(), p -> true);
        TextField campoBusqueda = new TextField();
        campoBusqueda.setPromptText("Buscar por nombre...");
        campoBusqueda.textProperty().addListener((obs, oldVal, newVal) -> {
            filtrados.setPredicate(c ->
                    newVal == null || newVal.isEmpty() ||
                            c.getNombre().toLowerCase().contains(newVal.toLowerCase()) ||
                            c.getApellido().toLowerCase().contains(newVal.toLowerCase())
            );
        });
        tabla.setItems(filtrados);
    }
}
