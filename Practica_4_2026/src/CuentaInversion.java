public class CuentaInversion extends CuentaDebito {

    public CuentaInversion(String nombre, String domicilio, String numeroCuenta, double saldoaFavor) {
        super(nombre, domicilio, numeroCuenta, saldoaFavor);
    }

    public double calcularRendimiento() {
        return saldoaFavor * 1.50;
    }

    @Override
    public void procesarTransaccion(double cantidad) {
        this.saldoaFavor += cantidad;
        System.out.println("Saldo inversión actualizado: " + saldoaFavor);
    }

    @Override
    public void consultarBalance() {
        super.consultarBalance();
        System.out.println("Rendimiento generado: " + calcularRendimiento());
    }
}