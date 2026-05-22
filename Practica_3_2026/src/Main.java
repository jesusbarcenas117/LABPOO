public class Main {
    public static void main(String[] args){
        System.out.println("Pruebas de validacion");


        Cuenta c1 = new Cuenta();

        c1.setSaldo(-500);
        //deberia imprimir error
        c1.setNombre("123JESUS");
        //error por numeros
        c1.setDomicilio("");
        //al estar vacio deberia rechazar

        //ahora bien llenado con datos validos

        c1.setNombre("Jesus");
        c1.setSaldo(5000);
        c1.setDeuda(150);
        c1.setDomicilio("mty");

        Cuenta c2 = new Cuenta();

        c2.setNombre("daniel");
        c2.setSaldo(1293);
        c2.setDeuda(52352);
        c2.setDomicilio("mty");

        //ahora llenamos el banco con las cuentas

        Banco banco = new Banco("Banorte", "Pinos suarez");
        banco.agregarCuenta(c1);
        banco.agregarCuenta(c2);

        banco.mostrarCuentas();


        System.out.println("Buscando la cuenta con el nombre 'Jesus'");
        Cuenta buscado = banco.buscarCuenta("Jesus");
        if (buscado != null){
            System.out.println(buscado);
        }


    }
}
