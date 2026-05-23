public abstract class CuentaAbstracta {

    protected String nombre;
    protected String numCuenta;
    protected double saldo;

    public CuentaAbstracta(String nombre, String numCuenta, double saldo) {
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getNumCuenta(){
        return numCuenta;
    }

    public double getSaldo(){
        return saldo;
    }

    public abstract void consultarBalance(); //esto lo implementan las clases hijas

    public void mostrarTitular(){
        System.out.println(nombre);
        System.out.println(numCuenta);
        System.out.println(saldo);
    }

    public void generarReporte() {
        System.out.println("=== REPORTE ===");
        mostrarTitular();
        consultarBalance();
    }
}
