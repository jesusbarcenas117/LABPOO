import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorBanco gestor = new GestorBanco();
        Scanner scanner = new Scanner(System.in);

        gestor.agregar(new Cuenta("Jesus Barcenas", "1001", 5000, "Monterrey", "ahorro"));
        gestor.agregar(new Cuenta("Daniel Lopez", "1002", 15000, "Guadalajara", "credito"));
        gestor.agregar(new Cuenta("Maria Garcia", "1003", 20000, "CDMX", "inversion"));
        gestor.agregar(new Cuenta("Pedro Ramirez", "1004", 3000, "Monterrey", "ahorro"));
        gestor.agregar(new Cuenta("Ana Torres", "1005", 8000, "Guadalajara", "ahorro"));
        gestor.agregar(new Cuenta("Carlos Mendez", "1006", 50000, "CDMX", "inversion"));
        gestor.agregar(new Cuenta("Laura Sanchez", "1007", 1200, "Monterrey", "ahorro"));
        gestor.agregar(new Cuenta("Roberto Diaz", "1008", 25000, "Tijuana", "credito"));
        gestor.agregar(new Cuenta("Sofia Herrera", "1009", 9000, "Guadalajara", "inversion"));
        gestor.agregar(new Cuenta("Miguel Castro", "1010", 4500, "CDMX", "ahorro"));
        gestor.agregar(new Cuenta("Elena Flores", "1011", 11000, "Monterrey", "credito"));
        gestor.agregar(new Cuenta("Andres Reyes", "1012", 30000, "Tijuana", "inversion"));
        gestor.agregar(new Cuenta("Patricia Vega", "1013", 2500, "Guadalajara", "ahorro"));
        gestor.agregar(new Cuenta("Fernando Luna", "1014", 18000, "CDMX", "credito"));
        gestor.agregar(new Cuenta("Gabriela Mora", "1015", 7000, "Monterrey", "ahorro"));

        int opcion = 0;
        while (opcion != 9) {
            System.out.println("\n=== MENU BANCO ===");
            System.out.println("1. Agregar cuenta");
            System.out.println("2. Buscar cuenta");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Actualizar saldo");
            System.out.println("5. Ordenar por nombre");
            System.out.println("6. Ordenar por saldo");
            System.out.println("7. Filtrar por tipo y saldo minimo");
            System.out.println("8. Mostrar todo");
            System.out.println("9. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Numero de cuenta: ");
                    String numCuenta = scanner.nextLine();
                    System.out.print("Saldo: ");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Domicilio: ");
                    String domicilio = scanner.nextLine();
                    System.out.print("Tipo (ahorro/credito/inversion): ");
                    String tipo = scanner.nextLine();
                    gestor.agregar(new Cuenta(nombre, numCuenta, saldo, domicilio, tipo));
                    System.out.println("Cuenta agregada.");
                    break;

                case 2:
                    System.out.print("Numero de cuenta: ");
                    String buscar = scanner.nextLine();
                    gestor.buscarConTiempo(buscar);
                    break;

                case 3:
                    System.out.print("Numero de cuenta a eliminar: ");
                    String eliminar = scanner.nextLine();
                    gestor.eliminar(eliminar);
                    System.out.println("Cuenta eliminada.");
                    break;

                case 4:
                    System.out.print("Numero de cuenta: ");
                    String actualizar = scanner.nextLine();
                    System.out.print("Nuevo saldo: ");
                    double nuevoSaldo = scanner.nextDouble();
                    scanner.nextLine();
                    gestor.actualizar(actualizar, nuevoSaldo);
                    System.out.println("Saldo actualizado.");
                    break;

                case 5:
                    gestor.ordenarPorNombre();
                    gestor.mostrarConIterador();
                    break;

                case 6:
                    gestor.ordenarPorSaldo();
                    gestor.mostrarConIterador();
                    break;

                case 7:
                    System.out.print("Tipo (ahorro/credito/inversion): ");
                    String filtroTipo = scanner.nextLine();
                    System.out.print("Saldo minimo: ");
                    double filtroSaldo = scanner.nextDouble();
                    scanner.nextLine();
                    List<Cuenta> resultado = gestor.filtrarPorTipoYSaldo(filtroTipo, filtroSaldo);
                    resultado.forEach(System.out::println);
                    break;

                case 8:
                    System.out.println("\n--- Cuentas ---");
                    gestor.mostrarConIterador();
                    System.out.println("\n--- Transacciones ---");
                    gestor.mostrarTransacciones();
                    System.out.println("\n--- Domicilios unicos ---");
                    gestor.mostrarDomicilios();
                    break;

                case 9:
                    System.out.println("Finalizando.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
        scanner.close();
    }
}