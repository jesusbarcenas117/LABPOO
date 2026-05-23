public class Main {
    public static void main(String[] args) {

        CuentaAhorro ca = new CuentaAhorro("Jesus", "1234567890", 5000);
        CuentaCredito cc = new CuentaCredito("Daniel", "0987654321", 3000, 15000);
        CuentaInversion ci = new CuentaInversion("Maria", "1122334455", 20000, 0.08);

        Banco banco = new Banco("Banorte");
        banco.agregarCuenta(ca);
        banco.agregarCuenta(cc);
        banco.agregarCuenta(ci);

        System.out.println("=== REPORTES ===");
        banco.mostrarCuentas();

        //demostramos combinaciones de interfaces
        System.out.println("\n=== TRANSFERENCIAS (solo CuentaAhorro) ===");
        ca.realizarTransferencia(1000, "Jesus2");
        ca.recibirTransferencia(500, "Daniel");

        System.out.println("\n=== NOTIFICACIONES (CuentaAhorro y CuentaCredito) ===");
        ca.enviarNotificacion("Depósito recibido");
        cc.enviarNotificacion("Pago mínimo próximo");

        System.out.println("\n=== CALCULOS (todas) ===");
        System.out.println("Interés ahorro: " + ca.calcularInteres());
        System.out.println("Interés crédito: " + cc.calcularInteres());
        System.out.println("Interés inversión: " + ci.calcularInteres());
    }
}