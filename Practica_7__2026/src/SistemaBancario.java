import java.io.FileWriter;
import java.io.IOException;

public class SistemaBancario {
    //con este log generamos el archivo para guardar los errores
    private void registrarLog(String mensaje) {
        try (FileWriter log = new FileWriter("errores.log", true)) {
            log.write(mensaje + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir log: " + e.getMessage());
        }
    }
    //ahora voy a meter funciones para calar
    public void retirar(double saldo, double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException(saldo, cantidad);
        }
        System.out.println("Retiro exitoso de: " + cantidad);
    }
    //las voy a procesar todas con una funcion que utilice las demas funciones en esta misma clase, por que si no voy
    //a hacer un espagueti

}