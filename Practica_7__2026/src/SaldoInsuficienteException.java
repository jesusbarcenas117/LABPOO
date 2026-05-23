public class SaldoInsuficienteException extends BancoException{
    private double saldoActual;
    private double montoIntentado;

    public SaldoInsuficienteException(double saldoActual, double montoIntentado) {
        super("Saldo insuficiente. Saldo actual: " + saldoActual + " | Monto intentado: " + montoIntentado);
        this.saldoActual = saldoActual;
        this.montoIntentado = montoIntentado;
    }

    public double getSaldoActual() { return saldoActual; }
    public double getMontoIntentado() { return montoIntentado; }
}
