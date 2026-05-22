public class CuentaCredito extends Cuenta{
    protected double saldoDeuda, limiteCredito;
    public CuentaCredito(String nombre, String numCuenta, String domicilio, double saldoDeuda, double limiteCredito) {
        super(nombre, numCuenta, domicilio);
        setsaldoDeuda(saldoDeuda);
        setlimiteCredito(limiteCredito);

    }


    public double getsaldoDeuda() {
        return saldoDeuda;
    }
    public double getlimiteCredito(){
        return limiteCredito;
    }

    public void setsaldoDeuda(double cantidad){
        if(cantidad<0){
            System.out.println("Introduzca una deuda de 0 o mayor");
        } else {
            this.saldoDeuda = cantidad;
        }
    }
    public void setlimiteCredito(double cantidad){
        if(cantidad<0){
            System.out.println("limite de credito invalido");
        } else if (cantidad == 0){
            System.out.println("No tienes limite de credito");
        } else {
            this.limiteCredito = cantidad;
        }

    }
    @Override
    public void procesarTransaccion(double cantidad) {
        if (saldoDeuda + cantidad > limiteCredito) {
            System.out.println("Error: supera el límite de crédito");
        } else {
            this.saldoDeuda += cantidad;
            System.out.println("Cargo realizado. Deuda actual: " + saldoDeuda);
        }
    }

    @Override
    public void consultarBalance() {
        super.consultarBalance();
        System.out.println("Deuda actual: " + saldoDeuda + " | Límite: " + limiteCredito);
    }

    @Override
    public String toString() {
        return super.toString() + ", deuda: " + saldoDeuda + ", limite: " + limiteCredito;
    }


    public void calcularInteresMensual() {
        double interes = saldoDeuda * 0.05;
        System.out.println("Interés mensual (5%): " + interes);
    }

}
