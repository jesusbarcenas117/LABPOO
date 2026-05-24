module com.example.practica_11_2026 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_11_2026 to javafx.fxml;
    exports com.example.practica_11_2026;
}