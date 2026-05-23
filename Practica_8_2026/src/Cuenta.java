import java.util.Objects;
//usé la misma clase de dominio de las practicas anteriores, agregando Comparable
public class Cuenta implements Comparable<Cuenta> {
    private String nombre;
    private String numeroCuenta;
    private double saldo;
    private String domicilio;
    private String tipoCuenta; // "ahorro", "credito", "inversion"

    public Cuenta(String nombre, String numeroCuenta, double saldo, String domicilio, String tipoCuenta) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.domicilio = domicilio;
        this.tipoCuenta = tipoCuenta;
    }

    public String getNombre() {
        return nombre;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public int compareTo(Cuenta otra) {
        return Double.compare(this.saldo, otra.saldo); // devuelve -0+ para saber el orden
    }

    @Override
    public String toString() {
        return "Cuenta{nombre: " + nombre +
                ", numero: " + numeroCuenta +
                ", saldo: " + saldo +
                ", domicilio: " + domicilio +
                ", tipo: " + tipoCuenta + "}";
    }
}