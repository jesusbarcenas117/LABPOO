//es casi el mismo molde que utilice las primeras practicas para la lista de bancos
import java.util.ArrayList;

public class Banco {
    private String nombreBanco;
    private ArrayList<CuentaAbstracta> cuentas;

    public Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
        this.cuentas = new ArrayList<>();
    }

    public String getNombreBanco() { return nombreBanco; }

    public void agregarCuenta(CuentaAbstracta cuenta) {
        cuentas.add(cuenta);
    }

    public void mostrarCuentas() {
        for (CuentaAbstracta c : cuentas) {
            c.generarReporte();
            System.out.println("---");
        }
    }
}