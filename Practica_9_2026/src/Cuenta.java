import java.io.Serializable;
//Es la misma clase cuenta de la practica pasada, solo le implemente serializable para sacar los snapshots
public class Cuenta implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String numeroCuenta;
    private double saldo;
    private String domicilio;
    private String tipoCuenta; // ahorro, credito, inversion

    public Cuenta(String nombre, String numeroCuenta, double saldo, String domicilio, String tipoCuenta) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.domicilio = domicilio;
        this.tipoCuenta = tipoCuenta;
    }

    public String getNombre() { return nombre; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }
    public String getDomicilio() { return domicilio; }
    public String getTipoCuenta() { return tipoCuenta; }

    public void setSaldo(double saldo) { this.saldo = saldo; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }


    @Override
    public String toString() {
        return "Cuenta{nombre: " + nombre +
                ", numero: " + numeroCuenta +
                ", saldo: " + saldo +
                ", domicilio: " + domicilio +
                ", tipo: " + tipoCuenta + "}";
    }
}