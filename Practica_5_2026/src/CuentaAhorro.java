public class CuentaAhorro extends CuentaAbstracta implements Calculables {

    public CuentaAhorro(String nombre, String numCuenta, double saldo){
        super(nombre, numCuenta, saldo);
    }

    public double calcularInteres(){
        return saldo*0.5;
    }

    public double calcularComision(){
        return 50;
    }

    //implementando el metodo de la clase padre

    public void consultarBalance(){
        System.out.println("Saldo actual: " + saldo + ", mas intereses: "+ calcularInteres());
    }
    //implementacion de sobrecarga de metodos

    public void depositar(double cantidad) {
        saldo += cantidad;
    }
    public void depositar(double cantidad, String concepto) {
        saldo += cantidad;
        System.out.println("Depósito por: " + concepto);
    }
    public void depositar(double cantidad, String concepto, boolean notificar) {
        saldo += cantidad;
        if (notificar) System.out.println("Notificación: depósito de " + cantidad + " por " + concepto);
    }
}


