public class LimiteCreditoException extends BancoException {
    public LimiteCreditoException(double limiteCredito, double montoIntentado) {
        super("Límite de crédito excedido. Límite: " + limiteCredito + " | Intentado: " + montoIntentado);
    }
}
