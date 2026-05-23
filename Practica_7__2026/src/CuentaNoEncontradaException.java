public class CuentaNoEncontradaException extends BancoException {
    public CuentaNoEncontradaException(String numeroCuenta) {
        super("Cuenta no encontrada: " + numeroCuenta);
    }
}
