public class CuentaDebito extends Cuenta {
    protected double saldoaFavor;
    public CuentaDebito(String nombre, String domicilio, String numCuenta, double saldoaFavor) {
        super(nombre, domicilio, numCuenta);
        setSaldoaFavor(saldoaFavor);

    }
    public double getSaldoaFavor() {
        return saldoaFavor;
    }

    public void setSaldoaFavor(double saldoaFavor){
        if (saldoaFavor<0){
            System.out.println("Saldo no valido");
        } else {
            this.saldoaFavor = saldoaFavor;
        }
    }
    @Override
    public void procesarTransaccion(double cantidad){
        this.saldoaFavor += cantidad;
        System.out.println("Saldo a favor: "+ saldoaFavor);
    }
    @Override
    public void consultarBalance(){
        super.consultarBalance();
        System.out.println("Saldo a favor: "+ saldoaFavor);
    }

    @Override

    public String toString(){
        return super.toString() + ", Saldo a favor: " + saldoaFavor;
    }
}
