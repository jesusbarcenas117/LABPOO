import java.util.Scanner;
public class CuentaHipoteca extends CuentaCredito {
    private int tiempoDeuda;
    private String direccionHipoteca;

    public CuentaHipoteca(String nombre, String numCuenta, String domicilio, double limiteCredito, double saldoDeuda, int tiempoDeuda, String direccionHipoteca) {
        super(nombre, numCuenta, domicilio, limiteCredito, saldoDeuda);
        this.tiempoDeuda = tiempoDeuda;
        this.direccionHipoteca = direccionHipoteca;
    }

    @Override
    public void procesarTransaccion(double cantidad) {
        System.out.print("Concepto: ");
        Scanner scanner = new Scanner(System.in);
        String concepto = scanner.nextLine();
        if (concepto.equals("credito hipotecario")) {
            super.procesarTransaccion(cantidad);
        } else {
            System.out.println("Error: concepto inválido para hipoteca");
        }
    }

    @Override
    public void consultarBalance() {
        super.consultarBalance();
        System.out.println("Hipoteca: " + direccionHipoteca + " | Tiempo: " + tiempoDeuda + " meses");
    }
}