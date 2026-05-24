public class Cliente implements Runnable {
    private CuentaBanco cuenta;
    private double cantidad;
    private String nombre;

    public Cliente(String nombre, CuentaBanco cuenta, double cantidad) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        System.out.println(nombre + " | Cliente depositando: " + cantidad);
        cuenta.depositar(cantidad);
    }
}