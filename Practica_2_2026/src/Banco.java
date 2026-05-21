import java.util.ArrayList;

public class Banco {
    String nombreBanco;
    ArrayList<Cuenta> cuentas;

    public Banco(String nombreBanco){
        this.nombreBanco = nombreBanco;
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
    public Cuenta buscarCuenta(String nombre, String domicilio){
        for (Cuenta c : cuentas){
            if(c.nombre.equals(nombre)){
                return c; //la cuenta fue encontrada
            }
        }
        return null; //no encontrada
    }

    public void mostrarCuentas(){
        for (Cuenta c : cuentas){
            System.out.println("Nombre: " + c.nombre + "|  saldo: " + c.saldo );
        }
    }
}
