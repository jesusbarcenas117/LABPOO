import java.util.ArrayList;

public class Banco {
    private String nombreBanco;
    private ArrayList<Cuenta> cuentas;

    public Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
        this.cuentas = new ArrayList<>();
    }

    public String getNombreBanco() { return nombreBanco; }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void mostrarCuentas() {
        for (Cuenta c : cuentas) {
            c.consultarBalance();
            System.out.println("---");
        }
    }

    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumCuenta().equals(numeroCuenta)) {
                return c;
            }
        }
        return null;
    }
}