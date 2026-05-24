import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {

    // 1. Leer CSV
    public List<Cuenta> leerCSV(String ruta) {
        List<Cuenta> cuentas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            br.readLine(); // saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Cuenta c = new Cuenta(
                        datos[0],           // nombre
                        datos[1],           // numeroCuenta
                        Double.parseDouble(datos[2]), // saldo
                        datos[3],           // domicilio
                        datos[4]            // tipo
                );
                cuentas.add(c);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo CSV: " + e.getMessage());
        }
        return cuentas;
    }
}