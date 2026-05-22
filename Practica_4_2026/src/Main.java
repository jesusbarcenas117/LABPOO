public class Main {
    public static void main (String[] args){
        Banco banco = new Banco("Banorte");

        // Un objeto de cada clase
        CuentaDebito cd = new CuentaDebito("Jesus", "Monterrey", "1234567890", 5000);
        CuentaCredito cc = new CuentaCredito("Daniel", "Guadalajara", "0987654321", 500, 15000);
        CuentaNomina cn = new CuentaNomina("Maria", "CDMX", "1122334455", 8000, "OXXO");
        CuentaInversion ci = new CuentaInversion("Pedro", "Monterrey", "5544332211", 20000);
        CuentaHipoteca ch = new CuentaHipoteca("Ana", "San Pedro", "9988776655", 50000, 500000, 240, "Av. Morones Prieto 123");

        // Agregar al banco
        banco.agregarCuenta(cd);
        banco.agregarCuenta(cc);
        banco.agregarCuenta(cn);
        banco.agregarCuenta(ci);
        banco.agregarCuenta(ch);

        System.out.println("=== BALANCE DE TODAS LAS CUENTAS ==="); //depende que tipo de cuenta sea, es lo que va a mostrar
        banco.mostrarCuentas();

        // Demostrar métodos propios de cada clase
        System.out.println("\n=== TRANSACCIONES ===");
        cd.procesarTransaccion(1000);
        cc.procesarTransaccion(3000);
        cn.procesarTransaccion(-2000); // adelanto de sueldo, permite negativo
        ci.procesarTransaccion(5000);

        System.out.println("\n=== METODOS PROPIOS ===");
        cc.calcularInteresMensual();
        ci.consultarBalance();

        System.out.println("\n=== BUSCAR CUENTA ===");
        Cuenta encontrada = banco.buscarCuenta("1234567890");
        if (encontrada != null) {
            encontrada.consultarBalance();
        }
    }
}
