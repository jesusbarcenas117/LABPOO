// solo calculable y notificable
public class CuentaCredito extends CuentaAbstracta implements Calculable, Notificable {
    private double limiteCredito;

    public CuentaCredito(String nombre, String numeroCuenta, double saldo, double limiteCredito) {
        super(nombre, numeroCuenta, saldo);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void consultarBalance() {
        System.out.println("Deuda: " + saldo + " | Límite: " + limiteCredito);
    }

    public double calcularInteres() { return saldo * 0.15; }
    public double calcularComision() { return 150.0; }

    public void enviarNotificacion(String mensaje) {
        System.out.println("Notificación CuentaCredito [" + nombre + "]: " + mensaje);
    }
}