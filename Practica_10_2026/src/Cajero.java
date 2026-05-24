public class Cajero extends Thread {
    private CuentaBanco cuenta;
    private double cantidad;
    private String operacion;

    public Cajero(String nombre, CuentaBanco cuenta, double cantidad, String operacion) {
        super(nombre);
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.operacion = operacion;
    }

    @Override
    public void run() {
        System.out.println(getName() + " | Iniciando operacion: " + operacion);
        if (operacion.equals("retiro")) {
            cuenta.retirar(cantidad);
        } else {
            cuenta.depositar(cantidad);
        }
    }
}