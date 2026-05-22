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
        if (saldo < 0) {
            System.out.println("Saldo negativo, no es posible de asignar");
        } else {
            this.saldo_debito = saldo;

        }
    }

    public void setDeuda(double deuda) {
        if (deuda < 0) {
            System.out.println("Deuda negativo, no es posible de asignar");
        } else {
            this.deuda_credito = deuda;
        }
    }

    public void setDireccionFiscal(String domicilio) {
        if (domicilio == null || domicilio.isEmpty()) {
            System.out.println("Domicilio vacio");
        } else {
            this.domicilio = domicilio;
        }
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Nombre vacio");
        } else if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚ]+")) {
            System.out.println("No se permiten caracteres especiales ni numeros");
        } else {
            this.nombre = nombre;
        }
    }

    //metodo toString, este es para poder imprimir datos de objetos como si fueran String nativos

    @Override
    public String toString(){
        return "Cuenta{" +"nombre: " + nombre + ", saldo: "+ saldo_debito +
                ", deuda: " + deuda_credito + ", domicilio: " + domicilio + "}";
    }
}
