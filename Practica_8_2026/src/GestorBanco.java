// me la voy a pelar aqui, disculpe las palabras
import java.util.*;
import java.util.stream.Collectors;
public class GestorBanco {
    private ArrayList<Cuenta> cuentas;
    private LinkedList<String> transacciones;
    private HashMap<String, Cuenta> mapaCuentas;
    private HashSet<String> domicilios;

    public GestorBanco(){
        cuentas = new ArrayList<>();
        transacciones = new LinkedList<>();
        mapaCuentas = new HashMap<>();
        domicilios = new HashSet<>();
    }

}
