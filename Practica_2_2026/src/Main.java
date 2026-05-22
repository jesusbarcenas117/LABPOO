public class Main {
    public static void main(String[] args){
        Banco banco = new Banco("Afirme");

        Cuenta c1 = new Cuenta( 1000, "jesus", "hacienda las flores", 21, 2500);
        Cuenta c2 = new Cuenta(5000, "daniel", "anahuac", 30, 35000);
        Cuenta c3 = new Cuenta( 1200, "jesus");
        Cuenta c4 = new Cuenta(500001, "beto");
        Cuenta c5 = new Cuenta("Monterrey", 1500);
        //metodos de banco
        banco.agregarCuenta(c1);
        banco.agregarCuenta(c2);
        banco.agregarCuenta(c3);
        banco.agregarCuenta(c4);
        banco.agregarCuenta(c5);
        banco.mostrarCuentas();
        System.out.println("\nBusqueda por nombre\n");
        Cuenta encontrado = banco.buscarCuenta("beto", "hacienda las flores");
        if (encontrado != null){
            System.out.println("Cuenta encontrada: " +encontrado.nombre);}
        else {
            System.out.println("Cuenta no encontrada");
        }
        System.out.println("\n");

        //Usamos metodos de la clase del dominio, las cuentas

        c1.depositarSaldo(3000);
        c2.agregarDeuda(15000);
        c3.retirarSaldo(500);
        c1.saldarDeuda(2500);
        c5.cambiarDomicilio("Palmas");

        System.out.println("Mostramos los resultados pero ahora con las funciones aplicadas");

        banco.mostrarCuentas();



    }
}
