import java.util.ArrayList;
public class Banco {
    protected String nombreBanco;
    protected ArrayList<Cuenta> cuentas;
    private String DireccionFiscal;


    //constructor

    public Banco(String nombreBanco, String DireccionFiscal){
        this.cuentas = new ArrayList<>();
        this.nombreBanco = nombreBanco;
        setdireccionFiscal(DireccionFiscal);
    }

    public String getNombreBanco(){
        return this.nombreBanco;
    }
    public String getDireccionFiscal(){
        return DireccionFiscal;
    }

    public void setdireccionFiscal(String DireccionFiscal){
        if (DireccionFiscal == null || DireccionFiscal.isEmpty()){
            System.out.println("No es posible ingresar cadenas vacias");
        } else {
            this.DireccionFiscal = DireccionFiscal;
        }
    }

    public Cuenta buscarCuenta(String nombre){
        for (Cuenta cuenta : cuentas){
            if (cuenta.getNombre().equals(nombre)){
                return cuenta;
            }
        }
        return null;
    }

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }

    public void mostrarCuentas(){
        for (Cuenta cuenta : cuentas){
            System.out.println(cuenta);
        }
    }


}
