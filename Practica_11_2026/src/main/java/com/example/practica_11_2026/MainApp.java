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
        Button btnAgregar = new Button("Agregar");
        Button btnEditar = new Button("Editar");
        Button btnEliminar = new Button("Eliminar");

        btnAgregar.setOnAction(e -> mostrarFormulario(null, stage));
        btnEditar.setOnAction(e -> {
            Cliente seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) mostrarFormulario(seleccionado, stage);
        });
        btnEliminar.setOnAction(e -> {
            Cliente seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) controller.eliminar(seleccionado);
        });

        HBox botones = new HBox(10, btnAgregar, btnEditar, btnEliminar);
        VBox root = new VBox(10, campoBusqueda, tabla, botones);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add(getClass().getResource("Estilos.css").toExternalForm());
        stage.setTitle("GymPOS - Gestion de Clientes");
        stage.setScene(scene);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabla.prefHeightProperty().bind(stage.heightProperty());
        VBox.setVgrow(tabla, Priority.ALWAYS);
        stage.show();
    }

    private void mostrarFormulario(Cliente cliente, Stage owner) {
        Stage modal = new Stage();
        modal.initModality(Modality.WINDOW_MODAL);
        modal.initOwner(owner);
        modal.setTitle(cliente == null ? "Agregar Cliente" : "Editar Cliente");

        TextField txtNombre = new TextField(cliente == null ? "" : cliente.getNombre());
        TextField txtApellido = new TextField(cliente == null ? "" : cliente.getApellido());
        TextField txtEmail = new TextField(cliente == null ? "" : cliente.getEmail());
        TextField txtTelefono = new TextField(cliente == null ? "" : cliente.getTelefono());
        ComboBox<String> cmbMembresia = new ComboBox<>();
        cmbMembresia.getItems().addAll("basica", "premium", "vip");
        cmbMembresia.setValue(cliente == null ? "basica" : cliente.getMembresia());

        Label lblError = new Label();
        lblError.setStyle("-fx-text-fill: red;");

        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            if (txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                lblError.setText("Nombre y email son obligatorios");
                return;
            }
            Cliente nuevo = new Cliente(
                    txtNombre.getText(), txtApellido.getText(),
                    txtEmail.getText(), txtTelefono.getText(),
                    cmbMembresia.getValue()
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
        form.addRow(4, new Label("Membresia:"), cmbMembresia);
        form.addRow(5, lblError, btnGuardar);

        modal.setScene(new Scene(form, 350, 280));
        modal.show();
    }

    public static void main(String[] args) {
        launch();
    }
}