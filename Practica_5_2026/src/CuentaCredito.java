public class CuentaCredito extends CuentaAbstracta implements Calculables {
    private double limiteCredito;

    public CuentaCredito(String nombre, String numCuenta, double saldo, double limiteCredito) {
        super(nombre, numCuenta, saldo);
        this.limiteCredito = limiteCredito;
    }

    public double calcularInteres() { return saldo * 0.15; }
    public double calcularComision() { return 150.0; }

    @Override
    public void consultarBalance() {
        System.out.println("Deuda: " + saldo + " | Límite: " + limiteCredito + " | Interés: " + calcularInteres());
    }

    public void cargar(double cantidad) { saldo += cantidad; }
    public void cargar(double cantidad, String concepto) {
        saldo += cantidad;
        System.out.println("Cargo: " + concepto);
    }
    public void cargar(double cantidad, String concepto, boolean validar) {
        if (validar && saldo + cantidad > limiteCredito) {
            System.out.println("Error: supera límite");
        } else {
            saldo += cantidad;
        }
    }
}