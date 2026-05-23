public class CuentaInversion extends CuentaAbstracta implements Calculables{
    private double rendimiento;

    public CuentaInversion(String nombre, String numCuenta, double saldo, double rendimiento) {
        super(nombre, numCuenta, saldo);
        this.rendimiento = rendimiento;
    }

    public double calcularInteres() { return saldo * rendimiento; }
    public double calcularComision() { return saldo * 0.01; }

    @Override
    public void consultarBalance() {
        System.out.println("Saldo: " + saldo + " | Rendimiento: " + calcularInteres());
    }

    public void invertir(double cantidad) { saldo += cantidad; }
    public void invertir(double cantidad, double nuevoRendimiento) {
        saldo += cantidad;
        this.rendimiento = nuevoRendimiento;
    }
    public void invertir(double cantidad, double nuevoRendimiento, String concepto) {
        saldo += cantidad;
        this.rendimiento = nuevoRendimiento;
        System.out.println("Inversión en: " + concepto);
    }
}