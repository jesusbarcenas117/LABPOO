public class Main {
    public static void main(String[] args) {

        SistemaBancario servicio = new SistemaBancario();

        System.out.println("=== PRUEBA 1: Saldo insuficiente ===");
        servicio.procesarOperacion(500, 1000, 0, 15000, "1234567890");

        System.out.println("\n=== PRUEBA 2: Límite de crédito excedido ===");
        servicio.procesarOperacion(5000, 500, 14000, 15000, "1234567890");

        System.out.println("\n=== PRUEBA 3: Cuenta no encontrada ===");
        servicio.procesarOperacion(5000, 500, 0, 15000, "9999999999");

        System.out.println("\n=== PRUEBA 4: Operación exitosa ===");
        servicio.procesarOperacion(5000, 500, 0, 15000, "1234567890");

        System.out.println("\n=== PRUEBA 5: Saldo exactamente igual al retiro ===");
        servicio.procesarOperacion(1000, 1000, 0, 15000, "1234567890");

        System.out.println("\n=== PRUEBA 6: Retiro de cero ===");
        servicio.procesarOperacion(0, 0, 0, 15000, "1234567890");

        System.out.println("\n=== PRUEBA 7: Deuda igual al límite ===");
        servicio.procesarOperacion(5000, 500, 15000, 15000, "1234567890");

        System.out.println("\n=== PRUEBA 8: Cuenta con caracteres especiales ===");
        servicio.procesarOperacion(5000, 500, 0, 15000, "ABC-999");

        System.out.println("\nRevisa el archivo errores.log para ver el registro de errores.");
    }
}