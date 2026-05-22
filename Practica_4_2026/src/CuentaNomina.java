public class CuentaNomina extends CuentaDebito {
    private String nominaEmpresa;  // solo el nombre, no el objeto Banco

    public CuentaNomina(String nombre, String domicilio, String numeroCuenta, double saldoaFavor, String nominaEmpresa) {
        super(nombre, domicilio, numeroCuenta, saldoaFavor);
        this.nominaEmpresa = nominaEmpresa;
    }

    public String getNominaEmpresa() { return nominaEmpresa; }

    @Override
    public void procesarTransaccion(double cantidad) {
        this.saldoaFavor += cantidad;
        System.out.println("Adelanto aplicado. Saldo: " + saldoaFavor);
    }

    @Override
    public void consultarBalance() {
        super.consultarBalance();
        System.out.println("Empresa nómina: " + nominaEmpresa);
    }

    @Override
    public String toString() {
        return super.toString() + ", empresa: " + nominaEmpresa;
    }
}