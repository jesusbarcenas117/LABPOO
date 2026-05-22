public class Cuenta {
    private String nombre;
    private String domicilio;
    private String numCuenta;

    public Cuenta(String nombre, String domicilio, String numCuenta) {

    }

    public String getNombre(){
        return this.nombre ;
    }
    public String getDomicilio(){
        return this.domicilio;
    }
    public String getNumCuenta(){
        return this.numCuenta;
    }

    public void setNombre(String nombre){
        if (nombre == null || nombre.isEmpty()){
           System.out.println("El nombre no puede estar vacio");
        } else {
            this.nombre = nombre;
        }
    }
    public void setDomicilio(String domicilio){
        if (domicilio == null || domicilio.isEmpty()){
            System.out.println("El domicilio no puede estar vacio");
        } else {
            this.domicilio = domicilio;
        }
    }
    public void setNumCuenta(String numCuenta){
        if (numCuenta == null || numCuenta.isEmpty()){
            System.out.println("El numCuenta no puede estar vacio");
        } else if (!numCuenta.matches("[0-9]+")){
            System.out.println("El numCuenta no puede estar vacio");
        } else {
            this.numCuenta = numCuenta;
        }
    }
}
