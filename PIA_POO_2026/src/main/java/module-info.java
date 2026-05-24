module com.example.pia_poo_2026 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pia_poo_2026 to javafx.fxml;
    exports com.example.pia_poo_2026;
    exports com.example.pia_poo_2026.view;
    opens com.example.pia_poo_2026.view to javafx.fxml;
}