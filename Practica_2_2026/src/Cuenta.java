public class Cuenta {
    double saldo;
    String nombre, domicilio;
    int edad;
    double deuda;

    //constructor1
    public Cuenta( double saldo, String nombre, String domicilio, int edad, double deuda) {
        this.saldo = saldo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.edad = edad;
        this.deuda = deuda;
    }
    //constructor2
    public Cuenta(double saldo, String nombre){
        this.nombre = nombre;
        this.saldo = saldo;
    }
   //constructor3;
    public Cuenta(String domicilio, double saldo){
        this.domicilio = domicilio;
        this.saldo = saldo;

    }

    public void depositarSaldo(double cantidad){
        this.saldo += cantidad;
    }

    public void retirarSaldo(double cantidad){
        this.saldo -= cantidad;
    }

    public void saldarDeuda(double cantidad){
        this.deuda -= cantidad;
    }

    public void cambiarDomicilio(String nuevoDomicilio){
        this.domicilio = nuevoDomicilio;
    }

    public void agregarDeuda(double cantidad){
        this.deuda  += cantidad;

    }


}
