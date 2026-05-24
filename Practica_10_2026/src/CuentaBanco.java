public class CuentaBanco {
    private double saldo;
    private String numeroCuenta;

    public CuentaBanco(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public synchronized void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println(Thread.currentThread().getName() +
                    " | RECHAZADO retiro de " + cantidad + " | Saldo insuficiente: " + saldo);
            return;
        }
        saldo -= cantidad;
        System.out.println(Thread.currentThread().getName() +
                " | Retiro: " + cantidad + " | Saldo restante: " + saldo);
    }

    public synchronized void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println(Thread.currentThread().getName() +
                " | Deposito: " + cantidad + " | Saldo actual: " + saldo);
    }

    public synchronized double getSaldo() {
        return saldo;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}