public class Main {
    public static void main(String[] args) {

        CuentaAbstracta[] cuentas = new CuentaAbstracta[3];
        cuentas[0] = new CuentaAhorro("Jesus", "1234567890", 5000);
        cuentas[1] = new CuentaCredito("Daniel", "0987654321", 3000, 15000);
        cuentas[2] = new CuentaInversion("Maria", "1122334455", 20000, 0.08);

        System.out.println("=== REPORTES ==="); //usamos el arreglo polimorfico
        for (CuentaAbstracta c : cuentas) {
            c.generarReporte();
            System.out.println("---");
        }

        System.out.println("\n=== CASTING E INSTANCEOF ===");
        for (CuentaAbstracta c : cuentas) {
            if (c instanceof CuentaAhorro) {
                CuentaAhorro ca = (CuentaAhorro) c;
                ca.depositar(1000, "nómina", true);
            } else if (c instanceof CuentaCredito) {
                CuentaCredito cc = (CuentaCredito) c;
                cc.cargar(500, "supermercado", true);
            } else if (c instanceof CuentaInversion) {
                CuentaInversion ci = (CuentaInversion) c;
                ci.invertir(5000, 0.10, "bonos");
            }
        }

        System.out.println("\n=== BALANCE FINAL ===");
        for (CuentaAbstracta c : cuentas) {
            c.consultarBalance();
        }
    }
}