import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {
    public List<Cuenta> leerCSV(String ruta) {
        List<Cuenta> cuentas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            br.readLine(); // Salta la primera linea
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
    public void escribirTexto(List<Cuenta> cuentas, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("=== REPORTE DE CUENTAS ===\n");
            for (Cuenta c : cuentas) {
                bw.write(c.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo: " + e.getMessage());
        }
    }

    public void serializar(Cuenta cuenta, String ruta) { //captura de pantalla pegada en el refri
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(cuenta);
            System.out.println("Cuenta serializada en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error serializando: " + e.getMessage());
        }
    }

    public Cuenta deserializar(String ruta) {//traer a la vida la captura de pantalla
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (Cuenta) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializando: " + e.getMessage());
            return null;
        }
    }

    public void hacerBackup(String rutaOriginal) { //
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String rutaBackup = "backup_" + timestamp + ".txt";
        try (
                BufferedReader br = new BufferedReader(new FileReader(rutaOriginal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(rutaBackup))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea + "\n");
            }
            System.out.println("Backup creado: " + rutaBackup);
        } catch (IOException e) {
            System.out.println("Error en backup: " + e.getMessage());
        }
    }

    public void exportarJSON(List<Cuenta> cuentas, String ruta) { //elegi json
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta c = cuentas.get(i);
            sb.append("  {\n");
            sb.append("    \"nombre\": \"" + c.getNombre() + "\",\n");
            sb.append("    \"numeroCuenta\": \"" + c.getNumeroCuenta() + "\",\n");
            sb.append("    \"saldo\": " + c.getSaldo() + ",\n");
            sb.append("    \"domicilio\": \"" + c.getDomicilio() + "\",\n");
            sb.append("    \"tipo\": \"" + c.getTipoCuenta() + "\"\n");
            sb.append("  }");
            if (i < cuentas.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(sb.toString());
            System.out.println("JSON exportado en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error exportando JSON: " + e.getMessage());
        }
    }
}