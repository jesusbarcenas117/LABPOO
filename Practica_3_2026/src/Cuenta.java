public class Cuenta {

    private String nombre, domicilio;
    private double saldo_debito, deuda_credito;

    public Cuenta(double saldo_debito, double deuda_credito, String nombre, String domicilio) {

        setSaldo(saldo_debito);
        setDeuda(deuda_credito);
        setNombre(nombre);
        setDomicilio(domicilio);
    }

    //getters
    public double getSaldo() {
        return this.saldo_debito;
    }
    public double getDeuda() {
        return this.deuda_credito;
    }
    public String getDomicilio() {
        return this.domicilio;
    }
    public String getNombre() {
        return this.nombre;
    }

    //setters

    public void setSaldo(double saldo) {
        if (saldo < 0){
            System.out.println("Saldo negativo, no es posible de asignar");
        } else {
            this.saldo_debito = saldo;

        }
    }
    public void setDeuda(double deuda) {
        if (deuda < 0){
            System.out.println("Deuda negativo, no es posible de asignar");
        } else {
            this.deuda_credito = deuda;
        }
    }
    public void setDomicilio(String domicilio){

    }
}
