import java.util.ArrayList;
public class Banco {
    protected String nombreBanco;
    protected ArrayList<Cuenta> cuentas;
    private String DireccionFiscal;


    //constructor

    public Banco(String nombreBanco, String direccionFiscal){
        this.cuentas = new ArrayList<>();
        this.nombreBanco = nombreBanco;
    }
}
