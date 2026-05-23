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

    public void agregar(Cuenta c){
        cuentas.add(c);
        mapaCuentas.put(c.getNumeroCuenta(), c);
        transacciones.add("Alta: "+c.getNombre());
        domicilios.add(c.getDomicilio());

    }

    public Cuenta buscar(String numeroCuenta){
        return mapaCuentas.get(numeroCuenta);
    }

    public void actualizar(String numeroCuenta, double nuevoSaldo){
        Cuenta c = buscar(numeroCuenta);
        if(c != null){
            c.setSaldo(nuevoSaldo);
            transacciones.add("Actualizacion: "+ c.getNombre() + ", Saldo: "+ nuevoSaldo);
        }
    }

    public void eliminar(String numeroCuenta){
        Cuenta c = buscar(numeroCuenta);
        if(c != null){
            cuentas.remove(c);
            mapaCuentas.remove(numeroCuenta);
            transacciones.add("Baja: "+c.getNombre());
        }
    }

    //ahora metemos los comparadores y veo que es el stream

    Comparator<Cuenta> porNombre = (a, b) -> a.getNombre().compareTo(b.getNombre());
    Comparator<Cuenta> porSaldo = (a, b) -> Double.compare(a.getSaldo(), b.getSaldo());

    public List<Cuenta> filtrarPorTipo(String tipo) {
        return cuentas.stream()
                .filter(c -> c.getTipoCuenta().equals(tipo))
                .collect(Collectors.toList());
    }

    public List<Cuenta> filtrarPorTipoYSaldo(String tipo, double saldoMinimo) {
        return cuentas.stream()
                .filter(c -> c.getTipoCuenta().equals(tipo))
                .filter(c -> c.getSaldo() >= saldoMinimo)
                .collect(Collectors.toList());
    }

    public void ordenarPorNombre() {
        cuentas.sort(porNombre);
    }

    public void ordenarPorSaldo() {
        Collections.sort(cuentas); // usa Comparable
    }

    public void mostrarConIterador() {
        Iterator<Cuenta> it = cuentas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void mostrarTransacciones() {
        for (String t : transacciones) {
            System.out.println(t);
        }
    }

    public void mostrarDomicilios() {
        System.out.println("Domicilios registrados: " + domicilios);
    }

    public void buscarConTiempo(String numeroCuenta) {
        long inicio = System.nanoTime();
        Cuenta c = buscar(numeroCuenta);
        long fin = System.nanoTime();
        System.out.println("Resultado: " + c);
        System.out.println("Tiempo HashMap: " + (fin - inicio) + " ns");
    }

    public int getTotalCuentas() { return cuentas.size(); }
    public ArrayList<Cuenta> getCuentas() { return cuentas; }


}
