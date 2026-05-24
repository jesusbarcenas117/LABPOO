import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorArchivos gestor = new GestorArchivos();
        Scanner scanner = new Scanner(System.in);
        List<Cuenta> cuentas = gestor.leerCSV("datos.csv");

        int opcion = 0;
        while (opcion != 7) {
            System.out.println("\n=== MENU I/O ===");
            System.out.println("1. Mostrar cuentas del CSV");
            System.out.println("2. Guardar reporte en texto");
            System.out.println("3. Serializar primera cuenta");
            System.out.println("4. Deserializar cuenta");
            System.out.println("5. Hacer backup del reporte");
            System.out.println("6. Exportar JSON");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    cuentas.forEach(System.out::println);
                    break;
                case 2:
                    gestor.escribirTexto(cuentas, "reporte.txt");
                    System.out.println("Reporte guardado.");
                    break;
                case 3:
                    gestor.serializar(cuentas.get(0), "cuenta.bin");
                    break;
                case 4:
                    Cuenta c = gestor.deserializar("cuenta.bin");
                    System.out.println("Cargada: " + c);
                    break;
                case 5:
                    gestor.hacerBackup("reporte.txt");
                    break;
                case 6:
                    gestor.exportarJSON(cuentas, "cuentas.json");
                    break;
                case 7:
                    System.out.println("Hasta luego.");
                    opcion = 7;
                    break;
            }
        }
        scanner.close();
    }
}