package com.example.pia_poo_2026.view;

import com.example.pia_poo_2026.controller.ClienteController;
import com.example.pia_poo_2026.controller.MembresiaController;
import com.example.pia_poo_2026.model.Cliente;
import com.example.pia_poo_2026.model.Membresia;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MembresiaView {
    private MembresiaController controller;
    private ClienteController clienteController;
    private TableView<Membresia> tabla = new TableView<>();

    public MembresiaView(MembresiaController controller, ClienteController clienteController) {
        this.controller = controller;
        this.clienteController = clienteController;
    }

    public VBox getVista() {
        // Columnas
        TableColumn<Membresia, String> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCliente().getNombre()));

        TableColumn<Membresia, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getTipo()));

        TableColumn<Membresia, String> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(d -> new SimpleStringProperty("$" + d.getValue().getPrecio()));

        TableColumn<Membresia, String> colInicio = new TableColumn<>("Inicio");
        colInicio.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getFechaInicio()));

        TableColumn<Membresia, String> colVence = new TableColumn<>("Vencimiento");
        colVence.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getFechaVencimiento()));

        TableColumn<Membresia, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().isActiva() ? "Activa" : "Vencida"));

        tabla.getColumns().addAll(colCliente, colTipo, colPrecio, colInicio, colVence, colEstado);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabla.setItems(controller.getMembresias());

        Button btnAgregar = new Button("Nueva Membresia");
        Button btnRenovar = new Button("Renovar");
        Button btnInactivar = new Button("Inactivar");
        btnInactivar.setOnAction(e -> {
            Membresia seleccionada = tabla.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                seleccionada.setActiva(false);
                controller.guardarCambios();
                tabla.refresh();
            }
        });

        btnAgregar.setOnAction(e -> mostrarFormulario());
        btnRenovar.setOnAction(e -> {
            Membresia seleccionada = tabla.getSelectionModel().getSelectedItem();
            if (seleccionada != null) mostrarRenovacion(seleccionada);
        });

        HBox botones = new HBox(10, btnAgregar, btnRenovar, btnInactivar);
        VBox vista = new VBox(10, tabla, botones);
        VBox.setVgrow(tabla, Priority.ALWAYS);
        vista.setPadding(new Insets(15));

        return vista;
    }

    private void mostrarFormulario() {
        Stage modal = new Stage();
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setTitle("Nueva Membresia");

        ComboBox<Cliente> cmbCliente = new ComboBox<>();
        cmbCliente.setItems(clienteController.getClientes());
        cmbCliente.setPromptText("Seleccionar cliente");

        ComboBox<String> cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("basica", "premium", "vip");
        cmbTipo.setValue("basica");
        TextField txtPrecio = new TextField();
        txtPrecio.setText("299");
        txtPrecio.setEditable(false); // Precio inamobible

        cmbTipo.setOnAction(e -> {
            if (cmbTipo.getValue().equals("basica")) txtPrecio.setText("299");
            else if (cmbTipo.getValue().equals("premium")) txtPrecio.setText("599");
            else if (cmbTipo.getValue().equals("vip")) txtPrecio.setText("999");
        });

        txtPrecio.setPromptText("Precio");
        TextField txtInicio = new TextField("2026-01-01");
        TextField txtVence = new TextField("2026-12-31");

        Label lblError = new Label();
        lblError.setStyle("-fx-text-fill: red;");

        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            if (cmbCliente.getValue() == null) {
                lblError.setText("Selecciona un cliente");
                return;
            }
            if (controller.clienteTieneMembresia(cmbCliente.getValue(), cmbTipo.getValue())) {
                lblError.setText("Este cliente ya tiene una membresia " + cmbTipo.getValue() + " activa");
                return;
            }
            try {
                Membresia m = new Membresia(
                        cmbTipo.getValue(),
                        Double.parseDouble(txtPrecio.getText()),
                        txtInicio.getText(),
                        txtVence.getText(),
                        cmbCliente.getValue()
                );
                controller.agregar(m);
                modal.close();
            } catch (NumberFormatException ex) {
                lblError.setText("Precio invalido");
            }
        });

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(15));
        form.addRow(0, new Label("Cliente:"), cmbCliente);
        form.addRow(1, new Label("Tipo:"), cmbTipo);
        form.addRow(2, new Label("Precio:"), txtPrecio);
        form.addRow(3, new Label("Inicio:"), txtInicio);
        form.addRow(4, new Label("Vencimiento:"), txtVence);
        form.addRow(5, lblError, btnGuardar);

        modal.setScene(new Scene(form, 350, 280));
        modal.show();
    }

    private void mostrarRenovacion(Membresia m) {
        Stage modal = new Stage();
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setTitle("Renovar Membresia");

        TextField txtNuevaFecha = new TextField("2027-12-31");
        Button btnRenovar = new Button("Renovar");

        btnRenovar.setOnAction(e -> {
            controller.renovar(m, txtNuevaFecha.getText());
            modal.close();
        });

        VBox form = new VBox(10,
                new Label("Cliente: " + m.getCliente().getNombre()),
                new Label("Nueva fecha vencimiento:"),
                txtNuevaFecha,
                btnRenovar
        );
        form.setPadding(new Insets(15));

        modal.setScene(new Scene(form, 300, 180));
        modal.show();
    }
}