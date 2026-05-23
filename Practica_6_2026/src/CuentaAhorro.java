//calculable, transferible y notificable
public class CuentaAhorro extends CuentaAbstracta implements Calculable, Transferible, Notificable{

    public CuentaAhorro(String nombre, String numeroCuenta, double saldo){
        super(nombre, numeroCuenta, saldo);
    }

    @Override
    public void consultarBalance(){
        System.out.println("Saldo: " + saldo + " | Interés: " + calcularInteres());
    }

    public double calcularInteres(){
        return saldo * 0.05;
    }
    public double calcularComision(){
        return 50.0;
    }

    public void realizarTransferencia(double cantidad, String destino){
        saldo -= cantidad;
        System.out.println("Transferencia de " + cantidad + " a " + destino);
    }
    public void recibirTransferencia(double cantidad, String origen){
        saldo += cantidad;
        System.out.println("Transferencia recibida de " + origen + ": " + cantidad);
    }

    public void enviarNotificacion(String mensaje){
        System.out.println("Notificación CuentaAhorro [" + nombre + "]: " + mensaje);
    }
}