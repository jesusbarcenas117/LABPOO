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
    public void cargarCredito(double deuda, double cantidad, double limite) throws LimiteCreditoException {
        if (deuda + cantidad > limite) {
            throw new LimiteCreditoException(limite, cantidad);
        }
        System.out.println("Cargo exitoso de: " + cantidad);
    }

    public void buscarCuenta(String numeroCuenta) throws CuentaNoEncontradaException {
        // Simulamos que solo existe la cuenta "1234567890"
        if (!numeroCuenta.equals("1234567890")) {
            throw new CuentaNoEncontradaException(numeroCuenta);
        }
        System.out.println("Cuenta encontrada: " + numeroCuenta);
    }

    public void procesarOperacion(double saldo, double cantidad, double deuda, double limite, String numeroCuenta) {
        try {
            retirar(saldo, cantidad);
            cargarCredito(deuda, cantidad, limite);
            buscarCuenta(numeroCuenta);
        } catch (SaldoInsuficienteException e) {
            System.out.println("ERROR: " + e.getMessage());
            registrarLog("SaldoInsuficienteException: " + e.getMessage());
        } catch (LimiteCreditoException e) {
            System.out.println("ERROR: " + e.getMessage());
            registrarLog("LimiteCreditoException: " + e.getMessage());
        } catch (CuentaNoEncontradaException e) {
            System.out.println("ERROR: " + e.getMessage());
            registrarLog("CuentaNoEncontradaException: " + e.getMessage());
        } catch (BancoException e) {
            System.out.println("ERROR GENERAL: " + e.getMessage());
            registrarLog("BancoException: " + e.getMessage());
        }
    }

}