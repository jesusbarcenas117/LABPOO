//solo calculable
public class CuentaInversion extends CuentaAbstracta implements Calculable{
    private double rendimiento;

    public CuentaInversion(String nombre, String numeroCuenta, double saldo, double rendimiento){
        super(nombre, numeroCuenta, saldo);
        this.rendimiento = rendimiento;
    }

    @Override
    public void consultarBalance(){
        System.out.println("Saldo: " + saldo + " | Rendimiento: " + calcularInteres());
    }

    public double calcularInteres(){
        return saldo * rendimiento;
    }
    public double calcularComision(){
        return saldo * 0.01;
    }
}