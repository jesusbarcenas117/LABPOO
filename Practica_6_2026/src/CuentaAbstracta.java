//reutilizare la de la practica anterior
public abstract class CuentaAbstracta {
    protected String nombre;
    protected String numeroCuenta;
    protected double saldo;

    public CuentaAbstracta(String nombre, String numeroCuenta, double saldo) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String getNombre() { return nombre; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }

    public abstract void consultarBalance();

    public void mostrarTitular() {
        System.out.println("Titular: " + nombre + " | Cuenta: " + numeroCuenta);
    }

    // Template Method
    public void generarReporte() {
        mostrarTitular();
        consultarBalance();
    }
}