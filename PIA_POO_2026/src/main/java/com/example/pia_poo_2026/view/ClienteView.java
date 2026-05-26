package com.example.pia_poo_2026.view;

import com.example.pia_poo_2026.controller.ClienteController;
import com.example.pia_poo_2026.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClienteView {
    private ClienteController controller;
    private TableView<Cliente> tabla = new TableView<>();

    public ClienteView(ClienteController controller) {
        this.controller = controller;
    }

    public VBox getVista() {
        TableColumn<Cliente, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getNombre()));

        TableColumn<Cliente, String> colApellido = new TableColumn<>("Apellido");
        colApellido.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getApellido()));

        TableColumn<Cliente, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getEmail()));

        TableColumn<Cliente, String> colTelefono = new TableColumn<>("Telefono");
        colTelefono.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getTelefono()));

        TableColumn<Cliente, String> colPuntos = new TableColumn<>("Puntos");
        colPuntos.setCellValueFactory(d -> new SimpleStringProperty(String.valueOf(d.getValue().getPuntos())));

        tabla.getColumns().addAll(colNombre, colApellido, colEmail, colTelefono, colPuntos);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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

        Button btnAgregar = new Button("Agregar");
        Button btnEditar = new Button("Editar");
        Button btnEliminar = new Button("Eliminar");

        btnAgregar.setOnAction(e -> mostrarFormulario(null));
        btnEditar.setOnAction(e -> {
            Cliente seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) mostrarFormulario(seleccionado);
        });
        btnEliminar.setOnAction(e -> {
            Cliente seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) controller.eliminar(seleccionado);
        });

        HBox botones = new HBox(10, btnAgregar, btnEditar, btnEliminar);
        VBox vista = new VBox(10, campoBusqueda, tabla, botones);
        VBox.setVgrow(tabla, Priority.ALWAYS);
        vista.setPadding(new Insets(15));

        return vista;
    }

    private void mostrarFormulario(Cliente cliente) {
        Stage modal = new Stage();
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setTitle(cliente == null ? "Agregar Cliente" : "Editar Cliente");

        TextField txtNombre = new TextField(cliente == null ? "" : cliente.getNombre());
        TextField txtApellido = new TextField(cliente == null ? "" : cliente.getApellido());
        TextField txtEmail = new TextField(cliente == null ? "" : cliente.getEmail());
        TextField txtTelefono = new TextField(cliente == null ? "" : cliente.getTelefono());

        Label lblError = new Label();
        lblError.setStyle("-fx-text-fill: red;");

        txtNombre.textProperty().addListener((obs, old, newVal) -> {
            if (newVal.isEmpty()) {
                lblError.setText("Nombre obligatorio");
            } else if (!newVal.matches("[a-zA-ZáéíóúÁÉÍÓÚ ]*")) {
                txtNombre.setText(old);
            } else {
                lblError.setText("");
            }
        });
        txtApellido.textProperty().addListener((obs, old, newVal) -> {
            if (!newVal.matches("[a-zA-ZáéíóúÁÉÍÓÚ ]*")) {
                txtApellido.setText(old);
            }
        });
        txtEmail.textProperty().addListener((obs, old, newVal) -> {
            if (newVal.isEmpty()) {
                lblError.setText("Email obligatorio");
            } else {
                lblError.setText("");
            }
        });

        txtTelefono.textProperty().addListener((obs, old, newVal) -> {
            if (!newVal.matches("\\d*")) {
                txtTelefono.setText(old);
            }
        });

        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            if (txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                lblError.setText("Nombre y email obligatorios");
                return;
            }
            Cliente nuevo = new Cliente(
                    txtNombre.getText(), txtApellido.getText(),
                    txtEmail.getText(), txtTelefono.getText()
            );
            if (cliente == null) {
                controller.agregar(nuevo);
            } else {
                controller.actualizar(cliente, nuevo);
            }
            modal.close();
        });

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(15));
        form.addRow(0, new Label("Nombre:"), txtNombre);
        form.addRow(1, new Label("Apellido:"), txtApellido);
        form.addRow(2, new Label("Email:"), txtEmail);
        form.addRow(3, new Label("Telefono:"), txtTelefono);
        form.addRow(4, lblError, btnGuardar);

        modal.setScene(new Scene(form, 350, 250));
        modal.show();
    }
}