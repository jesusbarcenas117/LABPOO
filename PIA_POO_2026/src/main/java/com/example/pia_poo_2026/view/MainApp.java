package com.example.pia_poo_2026.view;

import com.example.pia_poo_2026.controller.*;
import com.example.pia_poo_2026.exception.*;
import com.example.pia_poo_2026.model.*;
import com.example.pia_poo_2026.util.GeneradorReportes;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ClienteController cc = new ClienteController();
    private MembresiaController mc = new MembresiaController();
    private PagoController pc = new PagoController();
    private AccesoController ac = new AccesoController(mc);

    @Override
    public void start(Stage stage) {

        ClienteView clienteView = new ClienteView(cc);
        MembresiaView membresiaView = new MembresiaView(mc, cc);

        TabPane tabPane = new TabPane();

        Tab tabClientes = new Tab("Clientes", clienteView.getVista());
        tabClientes.setClosable(false);

        Tab tabMembresias = new Tab("Membresias", membresiaView.getVista());
        tabMembresias.setClosable(false);

        Tab tabPagos = new Tab("Pagos", crearVistaPagos());
        tabPagos.setClosable(false);

        Tab tabAccesos = new Tab("Accesos", crearVistaAccesos());
        tabAccesos.setClosable(false);

        tabPane.getTabs().addAll(tabClientes, tabMembresias, tabPagos, tabAccesos);

        Button btnReporte = new Button("Generar Reporte"); //barra superior
        btnReporte.setOnAction(e -> {
            Thread hilo = new Thread(new GeneradorReportes(
                    new java.util.ArrayList<>(cc.getClientes()),
                    new java.util.ArrayList<>(pc.getPagos())
            ));
            hilo.setDaemon(true);
            hilo.start();
            mostrarAlerta("Reporte", "Generando reporte en segundo plano...");
        });

        Label lblTitulo = new Label("GymPOS - Sistema de Gestion");
        lblTitulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        HBox toolbar = new HBox(10, lblTitulo, btnReporte);
        toolbar.setPadding(new Insets(10));

        VBox root = new VBox(toolbar, tabPane);
        VBox.setVgrow(tabPane, Priority.ALWAYS);

        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("GymPOS");
        stage.setScene(scene);
        stage.show();
    }

    private VBox crearVistaPagos() {
        TableView<Pago> tabla = new TableView<>();
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Pago, String> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(
                d.getValue().getCliente().getNombre()));

        TableColumn<Pago, String> colMonto = new TableColumn<>("Monto");
        colMonto.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(
                "$" + d.getValue().getMonto()));

        TableColumn<Pago, String> colConcepto = new TableColumn<>("Concepto");
        colConcepto.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(
                d.getValue().getConcepto()));

        TableColumn<Pago, String> colFecha = new TableColumn<>("Fecha");
        colFecha.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(
                d.getValue().getFecha()));

        tabla.getColumns().addAll(colCliente, colMonto, colConcepto, colFecha);
        tabla.setItems(pc.getPagos());

        Label lblTotal = new Label("Total recaudado: $0");
        pc.getPagos().addListener((javafx.collections.ListChangeListener<Pago>) c -> {
            lblTotal.setText("Total recaudado: $" + pc.getTotalRecaudado());
        });

        Button btnPagar = new Button("Registrar Pago");
        btnPagar.setOnAction(e -> mostrarFormularioPago());

        HBox botones = new HBox(10, btnPagar, lblTotal);
        VBox vista = new VBox(10, tabla, botones);
        VBox.setVgrow(tabla, Priority.ALWAYS);
        vista.setPadding(new Insets(15));
        return vista;
    }

    private VBox crearVistaAccesos() {
        TableView<AccesoGimnasio> tabla = new TableView<>();
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<AccesoGimnasio, String> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(
                d.getValue().getCliente().getNombre()));

        TableColumn<AccesoGimnasio, String> colEntrada = new TableColumn<>("Entrada");
        colEntrada.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(
                d.getValue().getFechaEntrada()));

        TableColumn<AccesoGimnasio, String> colSalida = new TableColumn<>("Salida");
        colSalida.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(
                d.getValue().getFechaSalida() != null ? d.getValue().getFechaSalida() : "En gimnasio"));

        tabla.getColumns().addAll(colCliente, colEntrada, colSalida);
        tabla.setItems(ac.getAccesos());

        Button btnEntrada = new Button("Registrar Entrada");
        Button btnSalida = new Button("Registrar Salida");

        btnEntrada.setOnAction(e -> mostrarFormularioAcceso());
        btnSalida.setOnAction(e -> {
            AccesoGimnasio seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                ac.registrarSalida(seleccionado.getCliente());
                tabla.refresh();
            }
        });

        HBox botones = new HBox(10, btnEntrada, btnSalida);
        VBox vista = new VBox(10, tabla, botones);
        VBox.setVgrow(tabla, Priority.ALWAYS);
        vista.setPadding(new Insets(15));
        return vista;
    }

    private void mostrarFormularioPago() {
        javafx.stage.Stage modal = new javafx.stage.Stage();
        modal.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        modal.setTitle("Registrar Pago");

        ComboBox<Cliente> cmbCliente = new ComboBox<>(cc.getClientes());
        cmbCliente.setPromptText("Seleccionar cliente");
        TextField txtMonto = new TextField();
        txtMonto.setPromptText("Monto");
        TextField txtConcepto = new TextField();
        txtConcepto.setPromptText("Concepto");

        Label lblError = new Label();
        lblError.setStyle("-fx-text-fill: red;");

        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            try {
                Pago p = new Pago(
                        Double.parseDouble(txtMonto.getText()),
                        java.time.LocalDate.now().toString(),
                        txtConcepto.getText(),
                        cmbCliente.getValue()
                );
                pc.procesarPago(p);
                modal.close();
            } catch (PagoInvalidoException ex) {
                lblError.setText(ex.getMessage());
            } catch (NumberFormatException ex) {
                lblError.setText("Monto invalido");
            }
        });

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(15));
        form.addRow(0, new Label("Cliente:"), cmbCliente);
        form.addRow(1, new Label("Monto:"), txtMonto);
        form.addRow(2, new Label("Concepto:"), txtConcepto);
        form.addRow(3, lblError, btnGuardar);

        modal.setScene(new javafx.scene.Scene(form, 320, 220));
        modal.show();
    }

    private void mostrarFormularioAcceso() {
        javafx.stage.Stage modal = new javafx.stage.Stage();
        modal.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        modal.setTitle("Registrar Entrada");

        ComboBox<Cliente> cmbCliente = new ComboBox<>(cc.getClientes());
        cmbCliente.setPromptText("Seleccionar cliente");

        ComboBox<Membresia> cmbMembresia = new ComboBox<>(mc.getMembresias());
        cmbMembresia.setPromptText("Seleccionar membresia");

        Label lblError = new Label();
        lblError.setStyle("-fx-text-fill: red;");

        Button btnGuardar = new Button("Registrar");
        btnGuardar.setOnAction(e -> {
            try {
                ac.registrarEntrada(cmbCliente.getValue(), cmbMembresia.getValue());
                modal.close();
            } catch (MembresiaVencidaException ex) {
                lblError.setText(ex.getMessage());
            }
        });

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(15));
        form.addRow(0, new Label("Cliente:"), cmbCliente);
        form.addRow(1, new Label("Membresia:"), cmbMembresia);
        form.addRow(2, lblError, btnGuardar);

        modal.setScene(new javafx.scene.Scene(form, 320, 180));
        modal.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.show();
    }

    public static void main(String[] args) {
        launch();
    }
}